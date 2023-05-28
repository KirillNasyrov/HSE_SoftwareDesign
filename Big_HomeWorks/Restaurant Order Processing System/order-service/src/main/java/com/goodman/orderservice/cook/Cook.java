package com.goodman.orderservice.cook;

import com.goodman.orderservice.entity.Order;
import com.goodman.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class Cook implements Runnable {
    OrderRepository orderRepository;
    Order order;

    public Cook(Order order, OrderRepository orderRepository) {
        this.order = order;
        this.orderRepository = orderRepository;
    }
    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(10000);
        order.setStatus("finished");
        order.setUpdatedAt(LocalDateTime.now());
        orderRepository.save(order);
    }
}
