/** @version $Id: MenuBuilder.java,v 1.6 2014/11/25 19:57:12 ist173522 Exp $ */
package poof.textui.main;

import ist.po.ui.Command;
import ist.po.ui.Menu;

import poof.core.SessionManager;

/**
 * Menu builder.
 */
public abstract class MenuBuilder {

	/**
	 * @param receiver
	 */
	public static void menuFor(SessionManager receiver) {
		Menu menu = new Menu(MenuEntry.TITLE, new Command<?>[] {
				new New(receiver),
				new Open(receiver),
				new Save(receiver),
				new Login(receiver),
				new MenuOpenShell(receiver),
				new MenuOpenUserManagement(receiver)
		});
		menu.open();
	}

}
