package com.shoppee.authentication.exceptions;

/*
 * This Exception is thrown when the user is not found in the database.
 */
public class UserNotFoundException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(final String message)
	{
		super(message);
	}

	public UserNotFoundException() {
		super();
	}

}
