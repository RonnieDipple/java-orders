package com.lambdaschool.demo.services;

import com.lambdaschool.demo.models.Customers;

import java.util.List;

public interface CustomersService {
    List<Customers> findAllCustomers(); //c can find all rests

    Customers findCustomersById(long id);// can find by

   /* Customers findCustomersByName(String name); //can find by name
    List<Customers> findByState(String state); //can find by state*/

    List<Customers> findByNameLike(String nameLike); //can find similar names
}
