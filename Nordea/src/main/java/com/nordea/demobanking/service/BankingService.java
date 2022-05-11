package com.nordea.demobanking.service;

import com.nordea.demobanking.model.EmployeeSavingDTO;

import reactor.core.publisher.Mono;

public interface BankingService {
	
	public Mono<EmployeeSavingDTO> getEmployeeSavings(String employeeID);

}
