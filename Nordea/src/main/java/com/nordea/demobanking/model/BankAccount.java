package com.nordea.demobanking.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankAccount {

	private Employee emp;
	
	private String bankName;

	private String ifsc;

	private BankStatement bankStatement;

}
