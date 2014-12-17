/** @version $Id: Shell.java,v 1.12 2014/11/27 13:44:41 ist175838 Exp $ */
package poof.textui;

import static ist.po.ui.Dialog.IO;

import java.io.IOException;
import java.io.FileNotFoundException;

import poof.core.SessionManager;
 

/**
 * Class that starts the application's textual interface.
 */
public class Shell {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionManager mysession = new SessionManager();
		String datafile = System.getProperty("import"); //$NON-NLS-1$
		 
		 //test datafile name validity?
		
		if (datafile != null) {
		      try{mysession.doImport(datafile);}
		      catch(FileNotFoundException e){
			IO.println("O ficheiro não existe.");
		      }
		      catch(IOException e){
			e.printStackTrace();
		      }
		}
		poof.textui.main.MenuBuilder.menuFor(mysession);
		IO.closeDown();
	}

}
