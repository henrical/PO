/** @version $Id: Login.java,v 1.14 2014/11/27 13:44:41 ist175838 Exp $ */
package poof.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;
 
import poof.core.SessionManager;
import poof.core.UnknownUserException;
import poof.textui.UserUnknownException;

/**
 * §2.1.2.
 */
public class Login extends Command<SessionManager> {

	/**
	 * @param receiver
	 */
	public Login(SessionManager receiver) {
		super(MenuEntry.LOGIN, receiver, new ValidateCommand(receiver));
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
	    Message message = new Message();
	    
	    String username = IO.readString(message.usernameRequest());
	    
	    try{	    
	    _receiver.logIn(username);
	    }
	    catch(UnknownUserException uue)
	    {
	      UserUnknownException exception = new UserUnknownException(uue.getUsername());
	      //IO.println(exception.getMessage());
	      throw exception;
	    }
	}
}
