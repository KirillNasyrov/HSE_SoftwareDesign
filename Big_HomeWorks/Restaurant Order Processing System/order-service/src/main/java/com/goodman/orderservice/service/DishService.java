package com.goodman.orderservice.service;

import com.goodman.orderservice.entity.Dish;
import com.goodman.orderservice.exception.CustomerAccessException;
import com.goodman.orderservice.exception.DishAlreadyExistException;
import com.goodman.orderservice.exception.IncorrectDishDataException;
import com.goodman.orderservice.exception.NoSuchDishException;
import com.goodman.orderservice.jwtValidationFilter.JwtValidationService;
import com.goodman.orderservice.repository.DishRepository;
import com.goodman.orderservice.request.EditDishQuantityRequest;
import com.goodman.orderservice.request.NewDishRequest;
import com.goodman.orderservice.response.DishResponse;
import com.goodman.orderservice.response.MenuResponse;
import com.goodman.orderservice.user.Role;
import com.goodman.orderservice.user.User;
import com.goodman.orderservice.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DishService {
    private final JwtValidationService jwtService;

    private final UserRepository userRepository;

    private final DishRepository dishRepository;

    public void addNewDish(HttpServletRequest request, NewDishRequest newDishRequest) {
        final String authHeader = request.getHeader("Authorization");
        String jwt = authHeader.substring(7);
        String userEmail = jwtService.extractEmail(jwt);
        Optional<User> user = userRepository.findByEmail(userEmail);
        if (user.get().getRole() == Role.CUSTOMER) {
            throw new CustomerAccessException("Customer can not add dishes");
        }
        if (dishRepository.findDishByName(newDishRequest.getName()).isPresent()) {
            throw new DishAlreadyExistException("Dish already exists");
        }
        if (newDishRequest.getPrice().doubleValue() <= 0 || newDishRequest.getQuantity() <= 0) {
            throw new IncorrectDishDataException("Dish data is incorrect");
        }
        Dish dish = Dish.builder()
                .name(newDishRequest.getName())
                .price(newDishRequest.getPrice())
                .description(newDishRequest.getDescription())
                .quantity(newDishRequest.getQuantity())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .available(true)
                .build();

        dishRepository.save(dish);
    }

    public void increaseDishQuantity(HttpServletRequest request, EditDishQuantityRequest dishQuantityRequest) {
        final String authHeader = request.getHeader("Authorization");
        String jwt = authHeader.substring(7);
        String userEmail = jwtService.extractEmail(jwt);
        Optional<User> user = userRepository.findByEmail(userEmail);
        if (user.get().getRole() == Role.CUSTOMER) {
            throw new CustomerAccessException("Customer can not add new dishes");
        }

        Optional<Dish> dish = dishRepository.findDishByName(dishQuantityRequest.getName());
        if (dish.isEmpty()) {
            throw new NoSuchDishException("Dish does not exist");
        }
        if (dishQuantityRequest.getQuantity() <= 0) {
            throw new IncorrectDishDataException("Dish data is incorrect");
        }

        int quantity = dish.get().getQuantity();
        dish.get().setQuantity(quantity + dishQuantityRequest.getQuantity());
        dishRepository.save(dish.get());
    }

    public MenuResponse getMenu() {
        var dishes = dishRepository.findAll();
        List<DishResponse> responseList = new ArrayList<>();
        for (var dish : dishes) {
            if (dish.isAvailable()) {
                responseList.add(DishResponse.builder()
                                .name(dish.getName())
                                .description(dish.getDescription())
                                .price(dish.getPrice())
                                .quantity(dish.getQuantity())
                                .build());
            }
        }

        return MenuResponse.builder()
                .menu(responseList)
                .build();
    }
}
