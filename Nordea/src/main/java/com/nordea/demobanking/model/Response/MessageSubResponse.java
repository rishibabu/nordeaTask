package com.nordea.demobanking.model.Response;

import com.nordea.demobanking.constants.MessageCode;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Builder
@Value
@ToString
public class MessageSubResponse {

	MessageCode code;
	String text;
}
