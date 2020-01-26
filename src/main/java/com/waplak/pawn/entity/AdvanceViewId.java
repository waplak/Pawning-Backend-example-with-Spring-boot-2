package com.waplak.pawn.entity;

import java.io.Serializable;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode
public class AdvanceViewId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1014523110682159741L;
	private String serialNo;
	private String detailId;
}
