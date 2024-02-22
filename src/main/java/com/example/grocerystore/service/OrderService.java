package com.example.grocerystore.service;

import com.example.grocerystore.dto.OrderDto;
import com.example.grocerystore.entity.Order;

import java.util.List;

public interface OrderService {
    String create(OrderDto orderDto);

    String getOrderDto();
}
