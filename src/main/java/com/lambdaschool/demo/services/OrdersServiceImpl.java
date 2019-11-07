package com.lambdaschool.demo.services;

import com.lambdaschool.demo.models.Orders;
import com.lambdaschool.demo.repositories.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "ordersService")
public class OrdersServiceImpl implements OrdersService {
    private OrdersRepository ordersRepository;


    @Override
    public List<Orders> findAll() {
        List<Orders> list = new ArrayList<>();
        ordersRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Orders findOrdersById(long id) {
        return ordersRepository.findByOrdNum(id);
    }
}
