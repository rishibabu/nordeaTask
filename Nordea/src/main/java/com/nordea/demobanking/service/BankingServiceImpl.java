package com.nordea.demobanking.service;

import static com.nordea.demobanking.constants.BankingConstants.DEMO_BANKING_API;
import static com.nordea.demobanking.constants.BankingConstants.DEMO_BANKING_API_PATH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.reactive.function.client.WebClient;

import com.nordea.demobanking.model.BankAccount;
import com.nordea.demobanking.model.EmployeeSavingDTO;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * 
 * @author rishi
 * demo banking service class
 *
 */
@Service
@Slf4j
public class BankingServiceImpl implements BankingService {

	@Autowired
	WebClient webClient;

	@Override
	public Mono<EmployeeSavingDTO> getEmployeeSavings(String employeeID) {

		

			Mono<BankAccount> account = WebClient.create(DEMO_BANKING_API).get()
					.uri(DEMO_BANKING_API_PATH + employeeID).retrieve().bodyToMono(BankAccount.class);

			return account.flatMap(acc -> {

				Integer saving = ObjectUtils.isEmpty(acc.getBankStatement()) ? 0
						: parseSaving(acc.getBankStatement().getIncome(), acc.getBankStatement().getExpense());

				return Mono.just(saving >= 0 ? EmployeeSavingDTO.builder().emp(acc.getEmp()).savings(saving).build()
						: EmployeeSavingDTO.builder().emp(acc.getEmp()).debt(saving).build());

			});	

		

	}

	private Integer parseSaving(Integer income, Integer expense) {

		return income - expense;

	}

}
