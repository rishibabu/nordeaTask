package com.nordea.demobanking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nordea.demobanking.model.BankAccount;
import com.nordea.demobanking.model.BankStatement;
import com.nordea.demobanking.model.Employee;
import com.nordea.demobanking.model.EmployeeSavingDTO;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

//@WebFluxTest(value = BankingService.class)
@ExtendWith(MockitoExtension.class)
public class BankingServiceTest {

	@InjectMocks
	BankingServiceImpl service;

	@Mock
	private WebClient webClientMock;
	@Mock
	private WebClient.RequestHeadersSpec requestHeadersMock;
	@Mock
	private WebClient.RequestHeadersUriSpec requestHeadersUriMock;
	@Mock
	private WebClient.RequestBodySpec requestBodyMock;
	@Mock
	private WebClient.RequestBodyUriSpec requestBodyUriMock;
	@Mock
	private WebClient.ResponseSpec responseMock;

	public static MockWebServer mockBackEnd;

//	@Mock
//	private ObjectMapper objectMapper;

	@BeforeAll
	static void setUp() throws IOException {
		mockBackEnd = new MockWebServer();
		mockBackEnd.start();
	}

	@AfterAll
	static void tearDown() throws IOException {
		mockBackEnd.shutdown();
	}

	@Test
	void testGetEmployeeSavings() throws JsonProcessingException {
		BankAccount account = BankAccount.builder().bankName("Citi")
				.bankStatement(BankStatement.builder().income(5000).expense(2500).build())
				.emp(Employee.builder().employeeID("EMP100").employeeName("Jacob").build()).build();

		EmployeeSavingDTO empDto = EmployeeSavingDTO.builder()
				.emp(Employee.builder().employeeID("EMP100").employeeName("Jacob").build()).savings(2500).build();

		String employeeID = "EMP100";
		
		ObjectMapper objectMapper = new ObjectMapper();
		

		mockBackEnd.enqueue(new MockResponse().setBody(objectMapper.writeValueAsString(account))
				.addHeader("Content-Type", "application/json"));

		empDto = service.getEmployeeSavings(employeeID);


		assertEquals(empDto.getEmp().getEmployeeID(), (employeeID));
		assertEquals(empDto.getSavings(), (2500));

	}

}
