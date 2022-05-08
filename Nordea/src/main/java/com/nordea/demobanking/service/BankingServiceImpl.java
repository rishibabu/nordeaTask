package com.nordea.demobanking.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nordea.demobanking.model.BankAccount;
import com.nordea.demobanking.model.BankStatement;
import com.nordea.demobanking.model.Employee;
import com.nordea.demobanking.model.EmployeeSavingDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BankingServiceImpl implements BankingService {

	private final WebClient webClient;

   public BankingServiceImpl()
   {
	   
	   this.webClient = WebClient.create("https://example.org");

   }


	@Override
	public EmployeeSavingDTO getEmployeeSavings(String employeeID) {

		BankAccount account = BankAccount.builder().bankName("Citi")
				.bankStatement(BankStatement.builder().income(5000).expense(2500).build())
				.emp(Employee.builder().employeeID("EMP100").employeeName("Jacob").build()).build();

		try
		{
		account = this.webClient.get().uri("/employee/"+employeeID).retrieve()
				.bodyToMono(BankAccount.class).block();
		
		}
		
		catch(Exception e)
		{
			log.info("catching the invocation exception"+e.getMessage());
		}

		Integer saving = parseSaving(account.getBankStatement().getIncome(), account.getBankStatement().getExpense());

		return saving >= 0 ? EmployeeSavingDTO.builder().emp(account.getEmp()).savings(saving).build()
				: EmployeeSavingDTO.builder().emp(account.getEmp()).debt(saving).build();

	}

	private Integer parseSaving(Integer income, Integer expense) {

		return income - expense;

	}

}
