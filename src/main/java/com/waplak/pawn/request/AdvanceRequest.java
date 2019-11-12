package com.waplak.pawn.request;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdvanceRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5903747697572776401L;
	private String branchId;
	private String nic;
	private String custFirstName;
	private String custLastName;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String karatCode;
	private double totFullWeight;
	private double totNetWeight;
	
}
