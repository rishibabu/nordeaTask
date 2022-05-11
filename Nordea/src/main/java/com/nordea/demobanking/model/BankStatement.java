package com.nordea.demobanking.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BankStatement {
	
	
	private Integer income;
	
	private Integer expense;
	
	@Builder
	public BankStatement(Integer income,Integer expense)
	{
		this.income = income;
		this.expense = expense;
	}

}
