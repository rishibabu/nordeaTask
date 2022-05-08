package com.nordea.demobanking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankStatement {
	
	
	private Integer income;
	
	private Integer expense;

}
