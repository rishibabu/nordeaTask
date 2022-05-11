package com.nordea.demobanking.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {

	private String employeeID;

	private String employeeName;
	
	@Builder
	public Employee(String employeeID,String employeeName)
	{
		this.employeeID = employeeID;
		this.employeeName = employeeName;
	}
	

}
