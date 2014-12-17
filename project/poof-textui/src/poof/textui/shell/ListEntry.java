/** @version $Id: ListEntry.java,v 1.6 2014/11/28 19:05:56 ist175838 Exp $ */
package poof.textui.shell;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

import java.util.ArrayList;

import poof.textui.EntryUnknownException;
import poof.core.SessionManager;
import poof.core.UnknownEntryException;

/**
 * §2.2.2.
 */
public class ListEntry extends Command<SessionManager>{
	/**
	 * @param receiver
	 */
	public ListEntry(SessionManager receiver ) {
		super(MenuEntry.LS_ENTRY, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException 
	{
	  Message message = new Message();
	  String name = IO.readString(message.nameRequest());
	  String output;
	
	  try{
	    output = _receiver.getEntryAttributes(name);
	     IO.println(output);
	    }
	  catch(UnknownEntryException e)
	  {
	    EntryUnknownException eue = new EntryUnknownException(e.getName());
	    //IO.println(eue.getMessage());
	    throw eue;
	  }
	}

}
