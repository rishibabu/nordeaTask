package com.nordea.demobanking.exception;

import com.nordea.demobanking.constants.MessageCode;

public class BankingServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6910224315079431320L;

	private final MessageCode code;
	private final String error;
	
	
	public BankingServiceException(MessageCode code,String message)
	{
		super(message);
		this.code = code;
		this.error = message;
	}
	
	public MessageCode getCode()
	{
		return code;
	}
	
	public String getError() {
		return error;
	}

}
