/** @version $Id: MenuBuilder.java,v 1.4 2014/11/27 13:44:42 ist175838 Exp $ */
package poof.textui.shell;

import ist.po.ui.Command;
import ist.po.ui.Menu;

import  poof.core.SessionManager;

/**
 * Menu builder for shell operations.
 */
public class MenuBuilder {

	/**
	 * @param receiver
	 */
	public static void menuFor(SessionManager receiver) {
		Menu menu = new Menu(MenuEntry.TITLE, new Command<?>[] {
				new ListAllEntries(receiver),
				new ListEntry(receiver),
				new RemoveEntry(receiver),
				new ChangeWorkingDirectory(receiver),
				new CreateFile(receiver),
				new CreateDirectory(receiver),
				new ShowWorkingDirectory(receiver),
				new AppendDataToFile(receiver),
				new ShowFileData(receiver),
				new ChangeEntryPermissions(receiver),
				new ChangeOwner(receiver),
				new ShowUserDirectory(receiver)
				});
		menu.open();
	}

}
