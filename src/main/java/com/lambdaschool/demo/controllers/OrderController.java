package com.lambdaschool.demo.controllers;

import com.lambdaschool.demo.models.Order;
import com.lambdaschool.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;
    public OrderController(@Qualifier("orderService") OrderService orderService) {

        this.orderService = orderService;
    }

    @GetMapping(value = "/order/{ordnum}", produces = {"application/json"})
    public ResponseEntity<?> getOrderByOrdnum(@PathVariable long ordnum) {
        Order myOrder = orderService.getOrderById(ordnum);
        return new ResponseEntity<>(myOrder, HttpStatus.OK);
    }

    @GetMapping(value = "/advanceamount/{advanceamount}", produces = {"application/json"})
    public ResponseEntity<?> getAllOrdersFilterByAdvanceAmount(@PathVariable double advanceamount){
        List<Order> allOrders = orderService.findAll();
        List<Order> returnOrders = new ArrayList<>();
        for (int i = 0; i < allOrders.size(); i++) {
            if (allOrders.get(i).getAdvanceamount() > advanceamount) {
                returnOrders.add(allOrders.get(i));
            }
        }
        return new ResponseEntity<>(returnOrders, HttpStatus.OK);
    }
}
