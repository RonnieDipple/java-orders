package com.lambdaschool.demo.repositories;

import com.lambdaschool.demo.models.Payments;
import org.springframework.data.repository.CrudRepository;

public interface PaymentsRepository extends CrudRepository<Payments, Long> {
}
