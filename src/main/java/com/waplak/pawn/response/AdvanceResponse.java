package com.waplak.pawn.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvanceResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6863274818018031069L;
	private String serialNumber;
}
