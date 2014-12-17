/** @version $Id: MenuOpenUserManagement.java,v 1.5 2014/11/25 19:57:12 ist173522 Exp $ */
package poof.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import ist.po.ui.ValidityPredicate;

import java.io.IOException;

import  poof.core.SessionManager;

/**
 * Open user management menu.
 */
public class MenuOpenUserManagement extends Command<SessionManager> {

	/**
	 * @param receiver
	 */
	public MenuOpenUserManagement(SessionManager receiver) {
		super(MenuEntry.MENU_USER_MGT, receiver, new ValidateCommand(receiver));
	}

	/** @see ist.po.ui.Command#execute() */
	@Override
	public final void execute() {
		poof.textui.user.MenuBuilder.menuFor(_receiver);
	}

}
