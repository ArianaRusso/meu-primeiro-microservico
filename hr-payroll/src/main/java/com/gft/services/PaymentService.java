package com.gft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.entities.Payment;
import com.gft.entities.Worker;
import com.gft.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment (long workerId, int days) {
	
		Worker worker = workerFeignClient.findByAll(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
