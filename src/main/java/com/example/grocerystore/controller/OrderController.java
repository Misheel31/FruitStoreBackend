package com.example.grocerystore.controller;

import com.example.grocerystore.dto.OrderDto;
import com.example.grocerystore.entity.Order;
import com.example.grocerystore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> saveOrder(@RequestBody OrderDto orderDto) {
        try {
            orderService.create(orderDto);
            return ResponseEntity.ok("Order saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}
