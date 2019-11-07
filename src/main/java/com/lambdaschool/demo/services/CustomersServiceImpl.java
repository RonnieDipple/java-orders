package com.lambdaschool.demo.services;

import com.lambdaschool.demo.models.Customers;
import com.lambdaschool.demo.repositories.CustomersRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "customersService")
public class CustomersServiceImpl implements CustomersService {
    private CustomersRepository customersRepository;
    @Override
    public List<Customers> findAllCustomers() {
        List<Customers> list = new ArrayList<>();
        customersRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customers findCustomersById(long id) {
        return customersRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public List<Customers> findByNameLike(String nameLike) {
        return customersRepository.findBycustNameContaining(nameLike);
    }
}
