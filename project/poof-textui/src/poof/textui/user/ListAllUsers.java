/** @version $Id: ListAllUsers.java,v 1.7 2014/11/27 13:44:42 ist175838 Exp $ */
package poof.textui.user;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

import  poof.core.SessionManager;

/**
 * §2.3.2.
 */
public class ListAllUsers extends Command<SessionManager>{
	/**
	 * @param receiver
	 */
	public ListAllUsers(SessionManager receiver) {
		super(MenuEntry.LIST_USERS, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException  {
	//no extra exceptions
	  for(String user : _receiver.listUsers())
	  {
	    IO.println(user);
	  }
		    
	}
}
