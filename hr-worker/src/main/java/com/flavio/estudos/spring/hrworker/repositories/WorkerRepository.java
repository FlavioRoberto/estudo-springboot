package com.flavio.estudos.spring.hrworker.repositories;

import com.flavio.estudos.spring.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
