package com.flavio.estudos.spring.hrworker.controllers;

import com.flavio.estudos.spring.hrworker.entities.Worker;
import com.flavio.estudos.spring.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    @Value("${test.config}")
    private String TestConfig;

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/configs")
    public ResponseEntity<String> getConfigs(){
        return ResponseEntity.ok(TestConfig);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable long id){
        Worker worker = repository.findById(id).get();
        return ResponseEntity.ok(worker);
    }
}
