package com.waplak.pawn.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NicResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1568797870029587509L;
	private String serialNumber;
	private String custFirstName;
	private String custLastName;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;

}
