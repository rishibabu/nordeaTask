package com.nordea.demobanking.exceptionhandler;

import static com.nordea.demobanking.constants.MessageCode.ERR_GENERAL_ERROR;
import static com.nordea.demobanking.constants.MessageCode.ERR_USER_NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nordea.demobanking.constants.MessageCode;
import com.nordea.demobanking.exception.BankingServiceException;
import com.nordea.demobanking.model.Response.ApiResponse;
import com.nordea.demobanking.model.Response.ErrorSubResponse;

@ControllerAdvice
/**
 * 
 * @author Rishi
 * custom error handler to display the error response in unique and elegant way
 *
 */
public class BankingServiceExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7765819461084989489L;

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex) {
		
		return buildResponseEntity(ERR_GENERAL_ERROR, ERR_GENERAL_ERROR.getError()  , UNPROCESSABLE_ENTITY);

	}
	
	
	@ExceptionHandler(BankingServiceException.class)
	public final ResponseEntity<Object> handleBankingServiceException(BankingServiceException ex) {
		
		return buildResponseEntity(ERR_USER_NOT_FOUND, ERR_USER_NOT_FOUND.getError()  , UNPROCESSABLE_ENTITY);

	}


	private ResponseEntity<Object> buildResponseEntity(MessageCode code,String message,HttpStatus status){
		
		ApiResponse<?> apiResponse = ApiResponse.builder().status(false).error(ErrorSubResponse.builder().code(code).text(message).build()).build();
		
		return new ResponseEntity<>(apiResponse,status);
		
	}

}
