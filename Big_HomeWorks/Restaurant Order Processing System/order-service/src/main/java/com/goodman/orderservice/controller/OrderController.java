package com.goodman.orderservice.controller;

import com.goodman.orderservice.exception.InvalidDishChoiceException;
import com.goodman.orderservice.request.OrderRequest;
import com.goodman.orderservice.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder (@NonNull HttpServletRequest request, @RequestBody OrderRequest orderRequest) {
        try {
            orderService.createOrder(request, orderRequest);
            return ResponseEntity.ok("order created");
        } catch (InvalidDishChoiceException e) {
            return ResponseEntity.badRequest().body("Can not choose some dishes");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Unknown mistake");
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getOrder (@NonNull HttpServletRequest request, @RequestParam int id) {
        try {
            orderService.getById(id);
            return ResponseEntity.ok(orderService.getById(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("No order with such id");
        } catch (InvalidDishChoiceException e) {
            return ResponseEntity.badRequest().body("Can not choose some dishes");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Unknown mistake");
        }
    }
}
