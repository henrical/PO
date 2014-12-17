/** @version $Id: ChangeEntryPermissions.java,v 1.5 2014/11/27 13:44:42 ist175838 Exp $ */
package poof.textui.shell;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
import  poof.core.SessionManager;
import poof.core.UnknownEntryException;
import poof.core.DeniedPermissionException;

import ist.po.ui.DialogException;

import poof.textui.AccessDeniedException;
import poof.textui.EntryUnknownException;

/**
 * §2.2.10.
 */
public class ChangeEntryPermissions extends Command<SessionManager> /* FIXME: select core type for receiver */ {
	/**
	 * @param receiver
	 */
	public ChangeEntryPermissions(SessionManager receiver /*FIXME: add receiver declaration: type must agree with the above*/) {
		super(MenuEntry.CHMOD, receiver /*FIXME: receiver argument*/);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
		String fileName = IO.readString(Message.nameRequest());

		String decision = IO.readString(Message.publicAccess());
		
		if(decision.equals("s") ||  decision.equals("S"))
		{
		    try{
		       _receiver.changePermission(fileName, "public"); 
		    }
		    catch(UnknownEntryException e)
		    {
			EntryUnknownException uee = new EntryUnknownException(e.getName());
			//IO.println(uee.getMessage());
			throw uee;
		    }
		    catch(DeniedPermissionException e)
		    {
			AccessDeniedException ade = new AccessDeniedException(e.getUsername());
			//IO.println(ade.getMessage());
			throw ade;
		    }
		 }
		 else if(decision.equals("n") ||  decision.equals("N"))
		 {
		    try{
		       _receiver.changePermission(fileName, "private"); //passar uma string ou fazer dois metodos diferentes? 
		    }
		    catch(UnknownEntryException e)
		    {
			EntryUnknownException uee = new EntryUnknownException(e.getName());
			//IO.println(uee.getMessage());
			throw uee;
		    }
		    catch(DeniedPermissionException e)
		    {
			AccessDeniedException ade = new AccessDeniedException(e.getUsername());
			//IO.println(ade.getMessage());
			throw ade;
		    }
		 }
	}
		
		
}


