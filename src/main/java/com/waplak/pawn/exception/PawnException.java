package com.waplak.pawn.exception;

public class PawnException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5388685553725238825L;
	
    public PawnException() {
    	super();
    }
    
    public PawnException(String message) {
		super(message);
	}
	
	public PawnException(String message, Throwable e) {
		super(message, e);
	}
}
