/** @version $Id: MenuOpenShell.java,v 1.5 2014/11/25 19:57:12 ist173522 Exp $ */
package poof.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

import  poof.core.SessionManager;

/**
 * Open shell menu.
 */
public class MenuOpenShell extends Command<SessionManager>{

	/**
	 * @param receiver
	 */
	public MenuOpenShell(SessionManager receiver) {
		super(MenuEntry.MENU_SHELL, receiver, new ValidateCommand(receiver));
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() {
		poof.textui.shell.MenuBuilder.menuFor(_receiver);
	}

}
