package com.lambdaschool.demo.services;

import com.lambdaschool.demo.models.Agent;
import com.lambdaschool.demo.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("agentService")
public class AgentServiceImpl implements AgentService {

    private AgentRepository agentRepository;

    private AgentServiceImpl(AgentRepository agentRepository) { this.agentRepository = agentRepository; }

    @Override
    public Agent getAgentById(long id) {
        return agentRepository.findById(id);
    }
}
