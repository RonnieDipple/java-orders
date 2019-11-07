package com.lambdaschool.demo.controllers;

import com.lambdaschool.demo.models.Orders;
import com.lambdaschool.demo.services.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private OrdersService ordersService;

    @GetMapping(value = "/order/{ordnum}", produces = {"application/json"})
    public ResponseEntity<?> getOrderByOrdNum(@PathVariable long ordNum) {
        Orders myOrder = ordersService.findOrdersById(ordNum);
        return new ResponseEntity<>(myOrder, HttpStatus.OK);
    }
}
