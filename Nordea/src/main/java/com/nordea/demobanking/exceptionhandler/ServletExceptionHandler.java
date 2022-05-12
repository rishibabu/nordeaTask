package com.nordea.demobanking.exceptionhandler;

import static com.nordea.demobanking.constants.MessageCode.ERR_MESSAGE_NOT_ALLOWED;

import javax.servlet.ServletException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.xml.sax.helpers.DefaultHandler;

import com.nordea.demobanking.constants.MessageCode;
import com.nordea.demobanking.model.Response.ApiResponse;
import com.nordea.demobanking.model.Response.ErrorSubResponse;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)

/**
 * 
 * @author Rishi
 * customizing the default handler to display the error response in unique and elegant way
 *
 */
public class ServletExceptionHandler extends DefaultHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7765819461084989489L;

	@ExceptionHandler(ServletException.class)
	public final ResponseEntity<Object> handleServletException(Exception ex) {
		
		return buildResponseEntity(ERR_MESSAGE_NOT_ALLOWED, ERR_MESSAGE_NOT_ALLOWED.getError()  , HttpStatus.METHOD_NOT_ALLOWED);

	}

	private ResponseEntity<Object> buildResponseEntity(MessageCode code,String message,HttpStatus status){
		
		ApiResponse<?> apiResponse = ApiResponse.builder().status(false).error(ErrorSubResponse.builder().code(code).text(message).build()).build();
		
		return new ResponseEntity<>(apiResponse,status);
		
	}

}
