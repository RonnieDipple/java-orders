package com.lambdaschool.demo.repositories;

import com.lambdaschool.demo.models.Agents;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AgentsRepository extends CrudRepository<Agents, Long> {
Agents findById(long agentCode);
}
