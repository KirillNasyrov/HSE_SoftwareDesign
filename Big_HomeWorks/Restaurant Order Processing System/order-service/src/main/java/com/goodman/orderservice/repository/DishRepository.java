package com.goodman.orderservice.repository;

import com.goodman.orderservice.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, Integer> {
    Optional<Dish> findDishByName(String name);
}
