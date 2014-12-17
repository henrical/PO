/** @version $Id: ShowWorkingDirectory.java,v 1.6 2014/11/27 13:44:42 ist175838 Exp $ */
package poof.textui.shell;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.core.SessionManager;

/**
 * §2.2.7.
 */
public class ShowWorkingDirectory extends Command<SessionManager>{
	/**
	 * @param receiver
	 */
	public ShowWorkingDirectory(SessionManager receiver) {
		super(MenuEntry.PWD, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() 
	{
	    IO.println(_receiver.getCurrentPath());
	}

}
