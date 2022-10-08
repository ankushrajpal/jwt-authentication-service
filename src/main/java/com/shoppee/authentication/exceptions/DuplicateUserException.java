package com.shoppee.authentication.exceptions;

/*
 * This Exception is thrown when we try to insert a user but the user with that email already exists.
 */
public class DuplicateUserException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	
	public DuplicateUserException(final String message)
	{
		super(message);
	}
	
	public DuplicateUserException()
	{
		super();
	}

}