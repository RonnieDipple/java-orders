package com.lambdaschool.demo.repositories;

import com.lambdaschool.demo.models.Customers;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CustomersRepository extends CrudRepository<Customers, Long> {
    ArrayList<Customers> findBycustNameContaining(String nameLike);
}
