package com.flavio.estudos.spring.hrworker.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_worker")
public class Worker implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double dailyIncome;

    public Worker() {
    }

    public Worker(Long id, String name, Double dailyIncome) {
        super();
        this.id = id;
        this.name = name;
        this.dailyIncome = dailyIncome;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }
}
