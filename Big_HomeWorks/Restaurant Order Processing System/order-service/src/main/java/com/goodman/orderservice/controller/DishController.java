package com.goodman.orderservice.controller;

import com.goodman.orderservice.exception.CustomerAccessException;
import com.goodman.orderservice.exception.DishAlreadyExistException;
import com.goodman.orderservice.exception.IncorrectDishDataException;
import com.goodman.orderservice.exception.NoSuchDishException;
import com.goodman.orderservice.request.EditDishQuantityRequest;
import com.goodman.orderservice.request.NewDishRequest;
import com.goodman.orderservice.service.DishService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    DishService dishService;

    @PostMapping("/new")
    public ResponseEntity<String> addNewDish(
            @NonNull HttpServletRequest request,
            @RequestBody NewDishRequest newDishRequest
    ) {
        try {
            dishService.addNewDish(request, newDishRequest);
            return ResponseEntity.ok("new dish added");
        } catch (CustomerAccessException e) {
            return ResponseEntity.badRequest().body("Customer can not add new dishes");
        } catch (DishAlreadyExistException e) {
            return ResponseEntity.badRequest().body("Dish already exists");
        } catch (IncorrectDishDataException e) {
            return ResponseEntity.badRequest().body("Dish data is incorrect");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Unknown mistake");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> increaseDishQuantity(
            @NonNull HttpServletRequest request,
            @RequestBody EditDishQuantityRequest dishQuantityRequest
            ) {
        try {
            dishService.increaseDishQuantity(request, dishQuantityRequest);
            return ResponseEntity.ok("quantity of dish is increased");
        } catch (CustomerAccessException e) {
            return ResponseEntity.badRequest().body("Customer can not add dishes");
        } catch (NoSuchDishException e) {
            return ResponseEntity.badRequest().body("Dish does not exist");
        } catch (IncorrectDishDataException e) {
            return ResponseEntity.badRequest().body("Dish data is incorrect");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Unknown mistake");
        }
    }

    @GetMapping("/menu")
    public ResponseEntity<?> getMenu(@NonNull HttpServletRequest request) {
        try {
            return ResponseEntity.ok(dishService.getMenu());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Unknown mistake");
        }
    }
}
