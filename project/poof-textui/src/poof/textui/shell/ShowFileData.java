/** @version $Id: ShowFileData.java,v 1.7 2014/11/29 15:19:28 ist175838 Exp $ */
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
import poof.textui.EntryUnknownException;
import poof.textui.IsNotFileException;
/**
 * §2.2.9.
 */
public class ShowFileData extends Command<SessionManager>{
	/**
	 * @param receiver
	 */
	public ShowFileData(SessionManager receiver) {
		super(MenuEntry.CAT, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
	  Message message = new Message();
	  String name = IO.readString(message.fileRequest());
	  
	  try
	  {
	    String text = _receiver.readFile(name);
	    if(!text.equals(""))
	    {
		IO.println(text);
	    }
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
	}
}
