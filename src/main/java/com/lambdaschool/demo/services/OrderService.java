package com.lambdaschool.demo.services;

import com.lambdaschool.demo.models.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(long ordnum); //c can find all rests

    List<Order> findAll();// can find by ordnum


}
