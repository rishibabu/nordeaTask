package com.nordea.demobanking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import com.nordea.demobanking.model.BankAccount;
import com.nordea.demobanking.model.BankStatement;
import com.nordea.demobanking.model.Employee;

import reactor.core.publisher.Mono;

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



@Test
void testGetEmployeeSavings()
{
	BankAccount account = BankAccount.builder().bankName("Citi")
			.bankStatement(BankStatement.builder().income(5000).expense(2500).build())
			.emp(Employee.builder().employeeID("EMP100").employeeName("Jacob").build()).build();

	String employeeID = "EMP100";
	  when(webClientMock.get()).thenReturn(requestHeadersUriMock);
      when(requestHeadersUriMock.uri("/employee/{id}", employeeID)).thenReturn(requestHeadersMock);
      when(requestHeadersMock.retrieve()).thenReturn(responseMock);
      when(responseMock.bodyToMono(BankAccount.class)).thenReturn(Mono.just(account));
      
		
	assertEquals(service.getEmployeeSavings(employeeID).getEmp().getEmployeeID(),(employeeID));
	assertEquals(service.getEmployeeSavings(employeeID).getSavings(),(2500));

	

}



}
