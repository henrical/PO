/** @version $Id: RemoveEntry.java,v 1.5 2014/11/27 13:44:42 ist175838 Exp $ */
package poof.textui.shell;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

import poof.core.SessionManager;
import poof.core.DeniedPermissionException;
import poof.core.IllegalEntryRemovalException;
import poof.core.UnknownEntryException;
import poof.textui.EntryUnknownException;
import poof.textui.AccessDeniedException;
import poof.textui.IllegalRemovalException;

/**
 * §2.2.3.
 */
public class RemoveEntry extends Command<SessionManager> {
	/**
	 * @param receiver
	 */
	public RemoveEntry(SessionManager receiver) {
		super(MenuEntry.RM, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
	  Message message = new Message();
	  String name = IO.readString(message.nameRequest());
	  
	  try
	  {
	    _receiver.removeEntry(name);
	  }
	  catch(UnknownEntryException e)
	  {
	    EntryUnknownException eue = new EntryUnknownException(e.getName());
	    //IO.println(eue.getMessage());
	    throw eue;
	  }
	  catch(DeniedPermissionException e)
	  {
	    AccessDeniedException ade = new AccessDeniedException(e.getUsername());
	    //IO.println(ade.getMessage());
	    throw ade;
	  }
	  catch(IllegalEntryRemovalException e)
	  {
	    IllegalRemovalException ire = new IllegalRemovalException();
	    //IO.println(ire.getMessage());
	    throw ire;
	  }
	}
}
