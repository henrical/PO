package poof.core;

import java.io.IOException;
/**
 * Attempt to change workspace into something other than a directory
 */
public class NotADirectoryException extends IOException {

	/** Invalid entry name */
	private final String name;

	/**
	 * @param name
	 */
	public NotADirectoryException(String name) {
		this.name = name;
	}
	
	public String getName()
	{
	    return name;
	}
}   
