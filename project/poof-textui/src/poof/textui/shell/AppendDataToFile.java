/** @version $Id: AppendDataToFile.java,v 1.5 2014/11/27 13:44:41 ist175838 Exp $ */
package poof.textui.shell;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
import poof.core.SessionManager;
import poof.core.UnknownEntryException;
import poof.core.NotAFileException;
import poof.core.DeniedPermissionException;
import poof.textui.EntryUnknownException;
import poof.textui.IsNotFileException;
import poof.textui.AccessDeniedException;
/**
 * §2.2.8.
 */
public class AppendDataToFile extends Command<SessionManager> {
	/**
	 * @param receiver
	 */
	public AppendDataToFile(SessionManager receiver) {
		super(MenuEntry.APPEND, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
	  Message message = new Message();
	  String name = IO.readString(message.fileRequest());
	  String text = IO.readString(message.textRequest());
	  
	  
	  try
	  {
	    _receiver.writeFile(name, text);
	  }
	  catch(UnknownEntryException e)
	  {
	    EntryUnknownException eue = new EntryUnknownException(e.getName());
	    //IO.println(eue.getMessage());
	    throw eue;
	  }
	  catch(NotAFileException e)
	  {
	    IsNotFileException infe = new IsNotFileException(e.getName());
	    //IO.println(infe.getMessage());
	    throw infe;
	  }
	  catch(DeniedPermissionException e)
	  {
	    AccessDeniedException ade = new AccessDeniedException(e.getUsername());
	    //IO.println(ade.getMessage());
	    throw ade;
	  }
	}

}
