package poof.core;

import java.io.IOException;
/**
 * Attempt to remove . or ..
 */
public class IllegalEntryRemovalException extends IOException {

	/** Invalid user */
	private final String username;

	/**
	 * @param username
	 */
	public IllegalEntryRemovalException(String username) {
		this.username = username;
	}
	
	public String getUsername()
	{
	    return username;
	}
}  
