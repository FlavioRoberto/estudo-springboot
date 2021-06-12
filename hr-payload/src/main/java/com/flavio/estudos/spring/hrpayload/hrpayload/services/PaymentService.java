package com.flavio.estudos.spring.hrpayload.hrpayload.services;

import com.flavio.estudos.spring.hrpayload.hrpayload.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days){
        return new Payment("João", 200.0, days);
    }
}
