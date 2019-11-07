package com.lambdaschool.demo.services;

import com.lambdaschool.demo.models.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> findAll(); //c can find all rests

    Orders findOrdersById(long id);// can find by id


}
