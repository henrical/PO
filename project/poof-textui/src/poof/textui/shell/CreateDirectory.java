/** @version $Id: CreateDirectory.java,v 1.6 2014/11/27 13:44:42 ist175838 Exp $ */
package poof.textui.shell;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.core.SessionManager;
import poof.core.DuplicateEntryException;
import poof.core.DeniedPermissionException;
import poof.textui.EntryExistsException;
import poof.textui.AccessDeniedException;

/**
 * §2.2.6.
 */
public class CreateDirectory extends Command<SessionManager>  {
	/**
	 * @param receiver
	 */
	public CreateDirectory(SessionManager receiver) {
		super(MenuEntry.MKDIR, receiver );
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
	   Message message = new Message();
	   String name = IO.readString(message.directoryRequest());
	   
	   try{
	      _receiver.createDirectory(name);
	    }
	  catch(DuplicateEntryException e)
	  {
	    EntryExistsException eee = new EntryExistsException(e.getName());
	    //IO.println(eee.getMessage());
	    throw eee;
	  }
	  catch(DeniedPermissionException e)
	  {
	    AccessDeniedException ade = new AccessDeniedException(e.getUsername());
	    //IO.println(ade.getMessage());
	    throw ade;
	  }
	}

}
