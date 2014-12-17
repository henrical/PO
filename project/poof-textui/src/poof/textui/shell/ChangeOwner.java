/** @version $Id: ChangeOwner.java,v 1.4 2014/11/27 13:44:42 ist175838 Exp $ */
package poof.textui.shell;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.core.*;

import poof.textui.AccessDeniedException;
import poof.textui.EntryUnknownException;
import poof.textui.UserUnknownException;

/**
 * §2.2.11.
 */
public class ChangeOwner extends Command<SessionManager> {
	/**
	 * @param receiver
	 */
	public ChangeOwner(SessionManager receiver ) {
		super(MenuEntry.CHOWN, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
	     String fileName = IO.readString(Message.nameRequest());
	     
	     String username = IO.readString(Message.usernameRequest());
	     
	     try{
	     _receiver.changeOwner(fileName, username);
	     }
	     catch(UnknownUserException e)
	     {
		 UserUnknownException uee = new UserUnknownException(e.getUsername());
		 //IO.println(uee.getMessage());
		 throw uee;
             }
	     catch(DeniedPermissionException e)
             {
	         AccessDeniedException ade = new AccessDeniedException(e.getUsername());
		 //IO.println(ade.getMessage());
		 throw ade;
	     }
	     catch(UnknownEntryException e)
	     {
	        EntryUnknownException eue = new EntryUnknownException(e.getName());
	        //IO.println(eue.getMessage());
	        throw eue;
	     }
	     
	     
	     
		
	}

}
