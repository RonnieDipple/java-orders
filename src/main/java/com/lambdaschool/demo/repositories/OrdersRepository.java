package com.lambdaschool.demo.repositories;

import com.lambdaschool.demo.models.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders, Long> {
    Orders findByOrdNum(long OrdNum);
}
