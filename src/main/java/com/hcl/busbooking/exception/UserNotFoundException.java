package com.hcl.busbooking.exception;

public class UserNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	public UserNotFoundException(String name) {
		 super("user not found");
	}
}
