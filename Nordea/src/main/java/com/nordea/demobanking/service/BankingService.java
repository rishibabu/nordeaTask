package com.nordea.demobanking.service;

import com.nordea.demobanking.model.EmployeeSavingDTO;

public interface BankingService {
	
	public EmployeeSavingDTO getEmployeeSavings(String employeeID);

}
