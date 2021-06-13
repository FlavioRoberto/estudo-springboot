package com.flavio.estudos.spring.hrpayload.hrpayload.services;

import com.flavio.estudos.spring.hrpayload.hrpayload.entities.Payment;
import com.flavio.estudos.spring.hrpayload.hrpayload.entities.Worker;
import com.flavio.estudos.spring.hrpayload.hrpayload.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days){
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
