/** @version $Id: Save.java,v 1.13 2014/11/27 13:44:41 ist175838 Exp $ */
package poof.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
 
import poof.core.SessionManager;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command<SessionManager> /* FIXME: select core type for receiver */ {
	/**
	 * @param receiver
	 */
	public Save(SessionManager receiver) {
		super(MenuEntry.SAVE, receiver, new ValidateCommand(receiver));
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
	Message message = new Message();
	String fileName;
	
	if(!_receiver.hasSaveFile())
	{
	  fileName = IO.readString(message.newSaveAs());
	}
	else fileName = _receiver.getSaveFile();
	
	try{
	_receiver.writeObjects(fileName);
	}
	catch(ClassNotFoundException e){
		  e.printStackTrace();
		 }
	}
}
