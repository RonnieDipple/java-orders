package com.lambdaschool.demo.controllers;

import com.lambdaschool.demo.models.Agent;
import com.lambdaschool.demo.services.AgentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agents")
public class AgentController {
    private AgentService agentService;

    public AgentController(@Qualifier("agentService") AgentService agentService) {

        this.agentService = agentService;
    }


    //http://localhost:2019/
    @GetMapping(value = "/agent/{id}", produces = {"application/json"})
    public ResponseEntity<?> getAgentById(@PathVariable long id) {
        Agent myAgent = agentService.getAgentById(id);
        return new ResponseEntity<>(myAgent, HttpStatus.OK);
    }
}
