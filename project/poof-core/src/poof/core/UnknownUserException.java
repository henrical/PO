package poof.core;

import java.io.IOException;
/**
 * Attempt to name an unknown user
 */
public class UnknownUserException extends IOException {

	/** Invalid user */
	private final String username;

	/**
	 * @param username
	 */
	public UnknownUserException(String username) {
		this.username = username;
	}
	
	public String getUsername()
	{
	    return username;
	}
} 
