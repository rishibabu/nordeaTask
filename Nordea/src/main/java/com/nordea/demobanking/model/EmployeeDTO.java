package com.nordea.demobanking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDTO {

	private Integer savings;
	
	private Integer debt;
	
	private Employee emp;
	
	
}
