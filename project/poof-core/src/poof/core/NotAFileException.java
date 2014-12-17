package poof.core;

import java.io.IOException;
/**
 * Attempt to write or read from something other than a File.
 */
public class NotAFileException extends IOException {

	/** Invalid entry name */
	private final String name;

	/**
	 * @param name
	 */
	public NotAFileException(String name) {
		this.name = name;
	}
	
	public String getName()
	{
	    return name;
	}
}    
