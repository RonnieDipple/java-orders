package com.lambdaschool.demo.services;

import com.lambdaschool.demo.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers(); //c can find all rests

    Customer getCustomerById(long id);// can find by

   /* Customers findCustomersByName(String name); //can find by name
    List<Customers> findByState(String state); //can find by state*/

    List<Customer> getCustomerByNameLike(String likename); //can find similar names
}
