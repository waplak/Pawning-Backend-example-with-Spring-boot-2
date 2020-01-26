package com.waplak.pawn.request;

import java.io.Serializable;

import org.hibernate.internal.build.AllowPrintStacktrace;

import com.waplak.pawn.entity.Users;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllowPrintStacktrace
@NoArgsConstructor
public class UserRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6540561311969861785L;
	
	private Users user;

}
