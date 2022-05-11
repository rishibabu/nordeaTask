package com.nordea.demobanking.controller;

import static com.nordea.demobanking.controller.BankingConstants.GET_SAVINGS_URL;
import static com.nordea.demobanking.controller.BankingConstants.REQUEST_MAPPING_URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nordea.demobanking.model.EmployeeSavingDTO;
import com.nordea.demobanking.service.BankingService;

import reactor.core.publisher.Mono;

/**
 * 
 * @author rishi This is the controller class for the dummy banking api
 */
@RestController
@RequestMapping(value = REQUEST_MAPPING_URL)
public class BankingController {

	@Autowired
	BankingService bankingService;

//	  @ApiOperation(value = "Find the player details", nickname = "Find the player details",
//	            notes = "It will retrieve the player details")
	@GetMapping(value = GET_SAVINGS_URL)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Mono<EmployeeSavingDTO>> getEmployeeDetails(@PathVariable String employeeID) {

		Mono<EmployeeSavingDTO> empDTO = null;
		empDTO = bankingService.getEmployeeSavings(employeeID);

		HttpStatus status = (empDTO != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(empDTO, status);

	}

}
