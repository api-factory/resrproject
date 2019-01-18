package com.wipro.restapi.exception;

public class InternalServerException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InternalServerException(String exception) {
	    super(exception);
	  }

}
