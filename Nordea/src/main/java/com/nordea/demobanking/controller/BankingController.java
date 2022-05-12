package com.nordea.demobanking.controller;

import static com.nordea.demobanking.constants.BankingConstants.GET_SAVINGS_URL;
import static com.nordea.demobanking.constants.BankingConstants.REQUEST_MAPPING_URL;
import static com.nordea.demobanking.constants.MessageCode.ERR_EMP_NOT_FOUND;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nordea.demobanking.exception.BankingServiceException;
import com.nordea.demobanking.model.EmployeeSavingDTO;
import com.nordea.demobanking.service.BankingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
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


	@GetMapping(value = GET_SAVINGS_URL)
	@ResponseStatus(HttpStatus.OK)
	@Parameter(name ="EmployeeID", schema = @Schema(description = "",type = "string", allowableValues = {"EMP100"}))
	@Operation(description = "Please provide the employee id as EMP100 for the sake of demo,other values will return error")
	public ResponseEntity<Mono<EmployeeSavingDTO>> getEmployeeDetails(@PathVariable String employeeID) {

		if(!employeeID.equalsIgnoreCase("EMP100"))
		{
			throw new BankingServiceException(ERR_EMP_NOT_FOUND, ERR_EMP_NOT_FOUND.getError());
		}
		Mono<EmployeeSavingDTO> empDTO = null;
		empDTO = bankingService.getEmployeeSavings(employeeID);

		HttpStatus status = (empDTO != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(empDTO, status);

	}

}
