package com.nordea.demobanking.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BankAccount {

	private Employee emp;
	
	private String bankName;

	private String ifsc;

	private BankStatement bankStatement;
	
	
	
	@Builder()
	  public BankAccount(Employee emp, String bankName,BankStatement bankStatement) {
	    this.emp = emp;
	    this.bankName = bankName;
	    this.bankStatement = bankStatement;
	  }

}
