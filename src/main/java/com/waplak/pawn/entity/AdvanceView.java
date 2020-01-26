package com.waplak.pawn.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CUSTOMER_ADVANCE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(AdvanceViewId.class)
public class AdvanceView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -276383391582939616L;
	
	@Id
	private String serialNo;
	@Id
	private String detailId;
	
	private String branchId; 
	private String custFirstName; 
	private String custLastName;
	private String nic;
	private String karatCode;
	private double totNetWeight;
	private String articleCatergory;
	private String articleType;

}
