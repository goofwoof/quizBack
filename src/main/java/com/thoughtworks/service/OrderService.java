package com.thoughtworks.service;

import com.thoughtworks.domain.Order;
import com.thoughtworks.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    public List<Order> getAllGoods() {
        return orderRepository.findAll().stream().map(orderDto -> {
            return Order.builder().Id(orderDto.getId()).goodId(orderDto.getGoodId()).
        });
    }
}
