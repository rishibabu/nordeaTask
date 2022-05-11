package com.nordea.demobanking.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import com.nordea.demobanking.model.Employee;
import com.nordea.demobanking.model.EmployeeSavingDTO;
import com.nordea.demobanking.service.BankingService;

import reactor.core.publisher.Mono;

@WebMvcTest(BankingController.class)
public class BankingControllerTest {

	@MockBean
	BankingService bankingServiceMock;

	@Autowired
	private WebTestClient webClient;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testGetEmployeeSavings() throws Exception {

		Employee employee = Employee.builder().employeeID("EMP100").employeeName("Albert").build();

		Mono<EmployeeSavingDTO> emp = Mono.just(EmployeeSavingDTO.builder().savings(2500).emp(employee).build());

		Mockito.when(bankingServiceMock.getEmployeeSavings("EMP100")).thenReturn(emp);

		webClient.get().uri("/demobanking/v1/employeesavings/{employeeID}", "EMP100").exchange().expectStatus().isOk()
				.expectBody().jsonPath("$.emp.employeeID").isNotEmpty().jsonPath("$.emp.employeeID").isEqualTo("EMP100")
				.jsonPath("$.emp.employeeName").isEqualTo("Albert").jsonPath("$.savings").isEqualTo(2500);

	}

}
