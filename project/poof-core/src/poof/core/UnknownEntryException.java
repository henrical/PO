package poof.core;

import java.io.IOException;
/**
 * Attempt to name an entity that doesn't exist in the directory
 */
public class UnknownEntryException extends IOException {

	/** Invalid entry name */
	private final String name;

	/**
	 * @param name
	 */
	public UnknownEntryException(String name) {
		this.name = name;
	}
	
	public String getName()
	{
	    return name;
	}
}  
