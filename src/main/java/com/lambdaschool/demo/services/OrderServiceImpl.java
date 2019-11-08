package com.lambdaschool.demo.services;

import com.lambdaschool.demo.models.Order;
import com.lambdaschool.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier(value = "orderService")
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrderById(long ordnum) {
        return orderRepository.findByOrdnum(ordnum);
    }

    @Override
    public List<Order> findAll() {

        List<Order> list = new ArrayList<>();
        orderRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}