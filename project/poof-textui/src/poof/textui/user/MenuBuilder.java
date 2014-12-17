/** @version $Id: MenuBuilder.java,v 1.4 2014/11/27 13:44:42 ist175838 Exp $ */
package poof.textui.user;

import ist.po.ui.Command;
import ist.po.ui.Menu;

import  poof.core.SessionManager;

/**
 * Menu builder for search operations.
 */
public class MenuBuilder {

	/**
	 * @param receiver
	 */
	public static void menuFor(SessionManager receiver) {
		Menu menu = new Menu(MenuEntry.TITLE, new Command<?>[] {
				new CreateUser(receiver),
				new ListAllUsers(receiver),
				});
		menu.open();
	}

}
