package com.nordea.demobanking.model.Response;

import com.nordea.demobanking.constants.MessageCode;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Builder
@Value
@ToString
public class ErrorSubResponse {

	MessageCode code;
	String text;

}
