package br.com.payroll.service;

import org.springframework.stereotype.Service;

import br.com.payroll.entities.Payment;

@Service
public class PaymentService {
    
    public Payment getPayment(Long workerId, Integer days) {
        return new Payment("Bob", 200.0, days);
    }

}
