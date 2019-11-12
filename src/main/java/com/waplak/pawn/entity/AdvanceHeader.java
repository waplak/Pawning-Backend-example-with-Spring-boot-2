package com.waplak.pawn.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ADVANCE_HEADER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvanceHeader implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 504011078627189818L;
	@Id
	@Column(name="SERIAL_NO")
	private String serialNumber;
	@Column(name="BRANCH_ID")
	private String branchId;
	@Column(name="NIC")
	private String nic;
	@Column(name="CUST_FIRST_NAME")
	private String custFirstName;
	@Column(name="CUST_LAST_NAME")
	private String custLastName;
	@Column(name="ADDRESS_LINE_1")
	private String addressLine1;
	@Column(name="ADDRESS_LINE_2")
	private String addressLine2;
	@Column(name="ADDRESS_LINE_3")
	private String addressLine3;
	@Column(name="KARAT_CODE")
	private String karatCode;
	@Column(name="TOT_FULL_WEIGHT")
	private double totFullWeight;
	@Column(name="TOT_NET_WEIGHT")
	private double totNetWeight;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;
}
