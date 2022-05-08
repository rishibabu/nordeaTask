package com.nordea.demobanking.service;

import com.nordea.demobanking.model.EmployeeDTO;

public interface BankingService {
	
	public EmployeeDTO getEmployeeSavings(String employeeID);

}
