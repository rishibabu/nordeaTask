package com.nordea.demobanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nordea.demobanking.model.EmployeeSavingDTO;
import com.nordea.demobanking.service.BankingService;

@RestController
public class BankingController {    
	
	
	public static final String ENDPOINT = "empsaving";

	
	@Autowired
	BankingService bankingService;
	
//	  @ApiOperation(value = "Find the player details", nickname = "Find the player details",
//	            notes = "It will retrieve the player details")
	    @RequestMapping(value = "/"+ENDPOINT + "/{employeeID}", method = RequestMethod.GET)
	    @ResponseBody
	    public HttpEntity<EmployeeSavingDTO> getEmployeeDetails(@PathVariable String employeeID) {
	    	EmployeeSavingDTO empDTO = null;
	    	empDTO  = bankingService.getEmployeeSavings(employeeID);
	        return new ResponseEntity<>(empDTO, empDTO != null ? HttpStatus.OK: HttpStatus.NOT_FOUND);
	    }

}
