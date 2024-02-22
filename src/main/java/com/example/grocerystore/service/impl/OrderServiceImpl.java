package com.example.grocerystore.service.impl;

import com.example.grocerystore.dto.OrderDto;
import com.example.grocerystore.entity.Order;
import com.example.grocerystore.entity.User;
import com.example.grocerystore.repository.OrderRepository;
import com.example.grocerystore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public String create(OrderDto orderDto) {
        Order order = new Order();
        order.setQuantity(orderDto.getQuantity());
        order.setPrice(orderDto.getPrice());
        order.setName(orderDto.getName());
        orderRepository.save(order);
        return "order created";
    }

    @Override
    public String getOrderDto() {
        return "Order purchased";
    }


}
