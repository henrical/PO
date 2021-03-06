package poof.textui;

import ist.po.ui.DialogException;

/**
 * Thrown when an invalid attempt is made to use an entry.
 */
public class IsNotDirectoryException extends DialogException {
	/** Class serial number (serialization). */
	private static final long serialVersionUID = 201408261552L;

	/** Invalid entry name. */
	private final String _entryName;

	/**
	 * @param entryName
	 */
	public IsNotDirectoryException(String entryName) {
		_entryName = entryName;
	}

	/**
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	@SuppressWarnings("nls")
	public String getMessage() {
		return "A entrada '" + _entryName + "' não é um directório.";
	}
}
