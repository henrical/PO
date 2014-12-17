/** @version $Id: ChangeWorkingDirectory.java,v 1.6 2014/11/27 13:44:42 ist175838 Exp $ */
package poof.textui.shell;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

import poof.core.SessionManager;
import poof.core.UnknownEntryException;
import poof.core.NotADirectoryException;
import poof.textui.EntryUnknownException;
import poof.textui.IsNotDirectoryException;

/**
 * §2.2.4.
 */
public class ChangeWorkingDirectory extends Command<SessionManager> {
	/**
	 * @param receiver
	 */
	public ChangeWorkingDirectory(SessionManager receiver ) {
		super(MenuEntry.CD, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
	  Message message = new Message();
	  String name = IO.readString(message.directoryRequest());
	  
	  try
	  {_receiver.changeDirectory(name);}
	  catch(UnknownEntryException e)
	  {
	    EntryUnknownException eue = new EntryUnknownException(e.getName());
	    //IO.println(eue.getMessage());
	    throw eue;
	  }
	  catch(NotADirectoryException e)
	  {
	    IsNotDirectoryException inde = new IsNotDirectoryException(e.getName());
	    //IO.println(inde.getMessage());
	    throw inde;
	  }
	}

}
