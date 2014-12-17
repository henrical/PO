/** @version $Id: ListAllEntries.java,v 1.5 2014/11/27 13:44:42 ist175838 Exp $ */
package poof.textui.shell;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

// FIXME: import project-specific classes
import  poof.core.SessionManager;

/**
 * §2.2.1.
 */
public class ListAllEntries extends Command<SessionManager>{
	/**
	 * @param receiver
	 */
	public ListAllEntries(SessionManager receiver) {
		super(MenuEntry.LS, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
	//no extra exceptions
		for(String entries : _receiver.listEntries())
		{
		  IO.println(entries);
		}
	}

}
