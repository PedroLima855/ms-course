package br.com.payroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.payroll.entities.Payment;
import br.com.payroll.entities.Worker;
import br.com.payroll.feignClients.WorkerFeignClients;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClients workerFeignClients;

    public Payment getPayment(Long workerId, Integer days) {

        Worker worker = workerFeignClients.findByIdWorker(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
