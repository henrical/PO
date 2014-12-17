package poof.textui.shell;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

import poof.core.SessionManager;
import poof.core.UnknownEntryException;
import poof.core.NotAFileException;
import poof.textui.EntryUnknownException;
import poof.textui.IsNotFileException;
/**
 * §2.2.9.
 */
public class ShowUserDirectory extends Command<SessionManager>{
	/**
	 * @param receiver
	 */
	public ShowUserDirectory(SessionManager receiver) {
		super("Mostrar directorio principal do utilizador", receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException 
	{
	    String username = IO.readString(Message.usernameRequest());
	    
	    IO.println(_receiver.listUserDirectory(username));
	    
	}
}