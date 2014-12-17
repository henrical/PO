package poof.core;

import java.io.IOException;
/**
 * Attempt to insert an intity whose name already exists in the directory
 */
public class DuplicateEntryException extends IOException {

	/** Invalid entry name */
	private final String name;

	/**
	 * @param name
	 */
	public DuplicateEntryException(String name) {
		this.name = name;
	}
	
	public String getName()
	{
	    return name;
	}
}   
