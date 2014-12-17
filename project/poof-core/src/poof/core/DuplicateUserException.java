package poof.core;

import java.io.IOException;
/**
 * Attempt to create a user whose username is alreay in use
 */
public class DuplicateUserException extends IOException {

	/** Invalid user */
	private final String username;

	/**
	 * @param username
	 */
	public DuplicateUserException(String username) {
		this.username = username;
	}
	
	public String getUsername()
	{
	    return username;
	}
} 
 
