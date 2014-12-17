/** @version $Id: New.java,v 1.11 2014/11/26 12:55:49 ist173522 Exp $ */
package poof.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

import  poof.core.SessionManager;

/**
 * Open a new file.
 */
public class New extends Command<SessionManager> {

	/**
	 * @param receiver
	 */
	public New(SessionManager receiver) {
		super(MenuEntry.NEW, receiver);
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, IOException {
	//corrigir para changed
	    _receiver.newFS();
	}

}
