package com.goodman.orderservice.repository;

import com.goodman.orderservice.entity.OrderDish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDishRepository extends JpaRepository<OrderDish, Integer> {
}
