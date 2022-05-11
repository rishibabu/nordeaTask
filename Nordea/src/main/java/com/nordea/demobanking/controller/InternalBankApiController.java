package com.nordea.demobanking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nordea.demobanking.model.BankAccount;
import com.nordea.demobanking.model.BankStatement;
import com.nordea.demobanking.model.Employee;

/**
 * 
 * @author rishi
 * This class is just for creating an internal API  which will act as a supplier to our
 * webclient call to mock the reactive behaviour of the webclient 
 */
@RestController
@RequestMapping(value="/demoapi")
public class InternalBankApiController {
	
	@GetMapping(value="/bankstatement/{EmployeeID}")
	@ResponseBody
	public BankAccount getBankStatement(@PathVariable String EmployeeID)
	{
		return BankAccount.builder().bankName("Citi")
				.bankStatement(BankStatement.builder().income(5000).expense(2500).build())
				.emp(Employee.builder().employeeID(EmployeeID).employeeName("Jacob").build()).build();
		
	}

}
