package com.nordea.demobanking.model.Response;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Builder
@Value
@ToString
public class ApiResponse<T> {
	
	Boolean status;
	ErrorSubResponse error;
	String message;
	T data;

}
