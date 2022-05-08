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
import org.springframework.test.web.servlet.MockMvc;

import com.nordea.demobanking.model.Employee;
import com.nordea.demobanking.model.EmployeeDTO;
import com.nordea.demobanking.service.BankingService;

@WebMvcTest(BankingController.class)
public class BankingControllerTest {

	
	@MockBean
	BankingService bankingServiceMock;
	
    
	
	 @Autowired
	  MockMvc mockMvc;
	 
    @Test
    public void testGetEmployeeSavings() throws Exception
    {
    	    	
    	Employee employee = Employee.builder().employeeID("EMP100").employeeName("Albert").build();
    	
    	EmployeeDTO emp = EmployeeDTO.builder().savings(2500).emp(employee).build();
    	
    	Mockito.when(bankingServiceMock.getEmployeeSavings("EMP100")).thenReturn(emp);
    	
    	mockMvc.perform(get("/empsaving/EMP100"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.emp.employeeID", Matchers.is("EMP100")))
        .andExpect(jsonPath("$.emp.employeeName", Matchers.is("Albert")))
        .andExpect(jsonPath("$.savings", Matchers.is(2500)));

        		
        	 	
    }



}
