package com.thoughtworks.api;

import com.thoughtworks.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/orders")
    public ResponseEntity getOrderList(){
        return ResponseEntity.ok(orderService.getAllGoods());
    }

}
