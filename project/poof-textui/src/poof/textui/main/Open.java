/** @version $Id: Open.java,v 1.18 2014/12/01 16:38:48 ist175838 Exp $ */
package poof.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;
import java.lang.reflect.*;

import poof.core.SessionManager;
 
import java.io.FileNotFoundException;
/**
 * Open existing file.
 */
public class Open extends Command<SessionManager> {

	/**
	 * @param receiver
	 */
	public Open(SessionManager receiver) {
		super(MenuEntry.OPEN, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	//catch IOexception // corrigir para changed
		
		Message message = new Message();
		
		String fileName = IO.readString(message.openFile());
		
		try{
		 _receiver.readObjectsFrom(fileName);
		}
		catch(FileNotFoundException e)
		{
		  IO.println(Message.fileNotFound());
		}
		catch(ClassNotFoundException e){
		}
	}
}
	



