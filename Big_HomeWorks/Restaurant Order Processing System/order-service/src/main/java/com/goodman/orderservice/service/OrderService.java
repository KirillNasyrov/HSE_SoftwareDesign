package com.goodman.orderservice.service;

import com.goodman.orderservice.cook.Cook;
import com.goodman.orderservice.entity.Order;
import com.goodman.orderservice.entity.OrderDish;
import com.goodman.orderservice.exception.InvalidDishChoiceException;
import com.goodman.orderservice.jwtValidationFilter.JwtValidationService;
import com.goodman.orderservice.repository.DishRepository;
import com.goodman.orderservice.repository.OrderDishRepository;
import com.goodman.orderservice.repository.OrderRepository;
import com.goodman.orderservice.request.OrderRequest;
import com.goodman.orderservice.response.OrderResponse;
import com.goodman.orderservice.user.User;
import com.goodman.orderservice.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final JwtValidationService jwtService;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final OrderRepository orderRepository;

    private final DishRepository dishRepository;

    private final OrderDishRepository orderDishRepository;

    public void createOrder(HttpServletRequest request, OrderRequest orderRequest) {
        final String authHeader = request.getHeader("Authorization");
        String jwt = authHeader.substring(7);
        String userEmail = jwtService.extractEmail(jwt);
        Optional<User> user = userRepository.findByEmail(userEmail);

        var dishNames = orderRequest.getDishNames();
        for (var dishName: dishNames) {
            if (dishRepository.findDishByName(dishName).isEmpty() ||
            !dishRepository.findDishByName(dishName).get().isAvailable()) {
                throw new InvalidDishChoiceException("Can not choose some dish");
            }
        }

        Order newOrder = Order.builder()
                .user(user.get())
                .status("cooking")
                .specialRequests(orderRequest.getSpecialRequests())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        orderRepository.save(newOrder);

        for (var dishName: dishNames) {
            var dish = dishRepository.findDishByName(dishName).get();
            var quantity = dish.getQuantity();
            dish.setQuantity(quantity - 1);
            OrderDish newOrderDish = OrderDish.builder()
                    .order(newOrder)
                    .dish(dish)
                    .price(dish.getPrice())
                    .quantity(dish.getQuantity())
                    .build();
            dishRepository.save(dish);
            orderDishRepository.save(newOrderDish);
        }

        Thread thread = new Thread(new Cook(newOrder, orderRepository));
        thread.start();
    }

    public OrderResponse getById(int id) {
        Order order = orderRepository.getReferenceById(id);
        var response = OrderResponse.builder()
                .specialRequests(order.getSpecialRequests())
                .status(order.getStatus())
                .build();
        return response;
    }
}
