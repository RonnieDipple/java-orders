package com.lambdaschool.demo.services;

import com.lambdaschool.demo.controllers.AgentsController;
import com.lambdaschool.demo.models.Agents;
import com.lambdaschool.demo.repositories.AgentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "agentsService")
public class AgentsServiceImpl implements AgentsService {

    @Autowired
    private AgentsRepository agentRepos;


    @Override
    public Agents findAgentById(long id) {
        return agentRepos.findById(id);

    }
}
