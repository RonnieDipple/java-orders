package com.lambdaschool.demo.controllers;

import com.lambdaschool.demo.models.Agents;
import com.lambdaschool.demo.services.AgentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agents")
public class AgentsController {

    @Autowired
    private AgentsService agentsService;

    //http://localhost:2019/
    @GetMapping(value = "/agent/{id}", produces = {"application/json"} )
    public ResponseEntity<?> findAgentById(@PathVariable long id) {
        Agents myAgents = agentsService.findAgentById(id);
        return new ResponseEntity<>(myAgents, HttpStatus.OK);

    }
}
