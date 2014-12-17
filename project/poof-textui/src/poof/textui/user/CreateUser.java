/** @version $Id: CreateUser.java,v 1.6 2014/11/27 13:44:42 ist175838 Exp $ */
package poof.textui.user;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;


import poof.core.SessionManager;
import poof.core.DuplicateUserException;
import poof.core.DeniedPermissionException;
import poof.textui.UserExistsException;
import poof.textui.AccessDeniedException;

/**
 * §2.3.1.
 */
public class CreateUser extends Command<SessionManager> {
	/**
	 * @param receiver
	 */
	public CreateUser(SessionManager receiver) {
		super(MenuEntry.CREATE_USER, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException 
	{
	  Message message = new Message();
	  
	  String username = IO.readString(message.usernameRequest());
	  String name = IO.readString(message.nameRequest());
	  
	  try{_receiver.addUser(username, name);}
	  catch(DuplicateUserException e)
	  {
	    UserExistsException uee = new UserExistsException(e.getUsername());
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
