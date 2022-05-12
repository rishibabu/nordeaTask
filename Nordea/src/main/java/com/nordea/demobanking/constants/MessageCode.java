package com.nordea.demobanking.constants;

public enum MessageCode {

	ERR_EMP_NOT_FOUND("The employee doesn't exist"),
	
	ERR_MESSAGE_NOT_ALLOWED("The method requested is not allowed,please use the appropriate http method"),
	
	ERR_GENERAL_ERROR("The System has encountered an error"),
	
	ERR_USER_NOT_FOUND("The requested user doesn't exist");



	private String error;

	MessageCode(String error) {

		this.error = error;

	}
	
	public void setError(String error)
	{
		this.error = error;
	}

	
	public String getError()
	{
		return error;
	}
}
