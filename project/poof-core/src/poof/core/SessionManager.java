package poof.core;

import java.util.ArrayList;

import java.io.*;

public class SessionManager{
  private User loggedUser = null;
  private Directory currentDir = null;
  private FileSystem currentFS = null;
  
  /*recebera argumentos? talvez objeto FS inicial ? ver multiplos construtores*/
  
  public void newFS()
  {
    currentFS = new FileSystem();
    loggedUser = currentFS.getUser("root");
    currentDir = currentFS.getUserHome("root");
  }
  
  public void logIn(String username) throws UnknownUserException
  { 
    if(currentFS.checkUser(username))
    {
      loggedUser = currentFS.getUser(username);
      currentDir = currentFS.getUserHome(username);
    }
    else
    {
	throw new UnknownUserException(username);
    }
  }
  
   public void logIn(User user) throws UnknownUserException
  { 
    String username = user.getUsername();
    if(currentFS.checkUser(username))
    {
      loggedUser = currentFS.getUser(username);
      currentDir = currentFS.getUserHome(username);
    }
    else
    {
	throw new UnknownUserException(username);
    }
  }

  public void addUser(String username, String name) throws DuplicateUserException,DeniedPermissionException
  {
    if(currentFS.checkUser(username))
    {
	throw new DuplicateUserException(username);
    }
 
    if(userIsRoot()){
	currentFS.addUser(new User(username, name));
      }
     else
     {
	throw new DeniedPermissionException(loggedUser.getUsername());
     }
   }

      
  public void removeEntry(String name) throws DeniedPermissionException, IllegalEntryRemovalException, UnknownEntryException
  {
    if(!(hasRemovePermission(name)))
    {
      throw new DeniedPermissionException(loggedUser.getUsername());
    }
    else if((name.equals(".")) || (name.equals("..")))
    {
      throw new IllegalEntryRemovalException(loggedUser.getUsername());
    } 
    else
    {
      currentFS.removeEntry(name, currentDir);
    }
  }
  
  public void changeDirectory(String name) throws NotADirectoryException, UnknownEntryException
  {
    if(!(currentDir.entryExists(name)))
	throw new UnknownEntryException(name);
  
    switch(name){
    case ".":
      break;
    case "..":
      currentDir = currentDir.getParent();
      break;
    default:
      if(currentDir.entryIsDirectory(name)) 
      {	
	  currentDir = (Directory)currentDir.getEntry(name);
      }
      else
      {
	  throw new NotADirectoryException(name);
      }
      break;
    }
  }
  
  public void createFile(String name) throws DeniedPermissionException,DuplicateEntryException
  {
    if(currentDir.entryExists(name)){
	throw new DuplicateEntryException(name);
    }
    
    if(hasPermission()){
	currentFS.createFile(name, loggedUser.getUsername(), currentDir);
    }
    else
    {
	throw new DeniedPermissionException(loggedUser.getUsername());
    }
  }
  
  public void createFile(String path, String name, String owner, String mode, String text) //usada pelo open
  {
      currentFS.createFile(path, name, owner, mode, text);
  }
  
  public void createDirectory(String name) throws DeniedPermissionException, DuplicateEntryException
  {
     if(currentDir.entryExists(name)){
	throw new DuplicateEntryException(name);
    }
  
    if(hasPermission())
    {
      currentFS.createDirectory(name, loggedUser.getUsername(), currentDir);
    }
    else
    {
	throw new DeniedPermissionException(loggedUser.getUsername());
    }
  }
  
  public void createDirectory(String path, String name, String owner, String mode)
  {
      currentFS.createDirectory(path, name, owner, mode);
  }
  
  public void writeFile(String name, String text) throws DeniedPermissionException, NotAFileException, UnknownEntryException
  {
    if(currentDir.entryIsDirectory(name))
	throw new NotAFileException(name);
     else if(!(currentDir.entryExists(name)))
	throw new UnknownEntryException(name);
  
    if(hasPermission(name)){
      currentFS.writeFile(name, text, currentDir);
      }
    else
    {
	throw new DeniedPermissionException(loggedUser.getUsername());
    }
  }
  
  public String readFile(String name) throws UnknownEntryException, NotAFileException
  {
    if(currentDir.entryIsDirectory(name)){
	throw new NotAFileException(name);
    }
    else if(!(currentDir.entryExists(name)))
	throw new UnknownEntryException(name);
	
    return currentFS.readFile(name, currentDir);
     
  }
  
  public void changePermission(String name, String mode) throws DeniedPermissionException, UnknownEntryException 
  {
    if(!(currentDir.entryExists(name)))
	throw new UnknownEntryException(name);
  
    if(hasPermission(name)){
      currentFS.changePermission(name, mode, currentDir);
    }
    else
    {
	throw new DeniedPermissionException(loggedUser.getName());
    }
  }
  
  public void changeOwner(String name, String owner) throws DeniedPermissionException, UnknownUserException, UnknownEntryException
  {
    if(!(currentFS.checkUser(owner)))
	throw new UnknownUserException(owner);
  
    if(!(currentDir.entryExists(name)))
	throw new UnknownEntryException(name);
  
    if(hasPermission(name))
    {
      currentFS.changeOwner(name, owner, currentDir);
    }
    else
    {
	throw new DeniedPermissionException(loggedUser.getName());
    }
  }
  
  public ArrayList<String> listUsers(){ return currentFS.listUsers();  }
  
  public ArrayList<String> listEntry(String name) throws UnknownEntryException
  {
    if(!(currentDir.entryExists(name)))
	throw new UnknownEntryException(name);
	
    return currentFS.listEntry(name, currentDir);
  }
 
  public String getCurrentPath()
  {
      return currentFS.getCurrentPath(currentDir);
  }
  
   public String getEntryAttributes(String name) throws UnknownEntryException
  {
      if(!(currentDir.entryExists(name)))
	throw new UnknownEntryException(name);
	
      return currentFS.getEntryAttributes(name, currentDir);
  }
  
  public void doImport(String file) throws FileNotFoundException, IOException
  {
    newFS();
  
    String entryName;
    String line;
    BufferedReader r = new BufferedReader(new FileReader(file));
    
    while((line = r.readLine()) != null)
    {
	String args[] = line.split("\\|");
	
	if(args[0].equals("USER"))
	{
	    addUser(args[1], args[2]); 
	}
	else if(args[0].equals("FILE"))
	{
	    
	    entryName = getNameFromPath(args[1]);
	    createFile(args[1], entryName, args[2], args[3], args[4]);
	}
	else if(args[0].equals("DIRECTORY"))
	{
	    entryName = getNameFromPath(args[1]);
	    createDirectory(args[1], entryName, args[2], args[3]);
	}
	else
	{
	  System.out.println("Uma linha nao esta bem formada.");
	}
    }
   }
 
 
  public ArrayList<String> listEntries(){return currentFS.listEntries(currentDir);}
 
  public User getLoggedUser(){return loggedUser;}
  
  public FileSystem getCurrentFS() {return currentFS;}
  
  public Directory getCurrentDir() {return currentDir;}
  
  public boolean getHasChanged() {return currentFS.getHasChanged();}
  
  public boolean isLoggedIn()
  {
    return loggedUser != null;
  }
  
  public void readObjectsFrom(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
  {
    ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
    
    User lastUser = (User)in.readObject();
    FileSystem lastFS = (FileSystem)in.readObject();
    
    loggedUser = lastUser;
    currentFS = lastFS;
    currentDir = currentFS.getUserHome(loggedUser.getUsername());
    
    in.close();
    
    currentFS.setSaveFile(fileName);
  }
  
  public void writeObjects(String fileName) throws IOException, ClassNotFoundException
  {
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
    
    out.writeObject(loggedUser);
    out.writeObject(currentFS);
    
    out.close();
  }
  
  public String getSaveFile()
  {
    return currentFS.getSaveFile();
  }
  
  public boolean hasSaveFile()
  {
    return currentFS.hasSaveFile();
  }
  
  /*Nao gosto muito disto mas fica melhor */
  private boolean userIsRoot() {return getLoggedUsername().equals("root");}

  private String getLoggedUsername()
  {
	return loggedUser.getUsername();
  }
  
  public String listUserDirectory(String username)
  {
      return currentFS.listUserDirectory(username);
  }
  
  
  private boolean hasRemovePermission(String name)
  {
    // dir e entry sao public || dono do dir é loggedUser && dono do entry é loggedUser ||
    // dir é public e dono da entry é loggedUser || dono da dir é loggedUser e entry é public || loggedUser é root
    return userIsRoot() || currentDir.getMode() && currentDir.getEntry(name).getMode() || 
	   currentDir.getOwner().equals(loggedUser.getUsername()) && 
	   currentDir.getEntry(name).getOwner().equals(loggedUser.getUsername()) ||
	   currentDir.getMode() && currentDir.getEntry(name).getOwner().equals(loggedUser.getUsername()) ||
	   currentDir.getEntry(name).getMode() && currentDir.getOwner().equals(loggedUser.getUsername());
  }
  
  /*Verifica permissao sobre operacoes sobre a pasta actual */
  private boolean hasPermission(){
    return userIsRoot() || getLoggedUsername().equals(currentDir.getOwner()) || currentDir.getMode();
  }
  
  /*Verifica permissao sobre operacoes sobre entidade de nome name*/
  private boolean hasPermission(String name) {
    return userIsRoot() || loggedUser.getUsername().equals(currentDir.getEntry(name).getOwner()) || 
	    currentDir.getEntry(name).getMode();
	    }
	    
  private String getNameFromPath(String path)
  {
      String parsedPath[] = path.split("/");
      
      return parsedPath[parsedPath.length - 1];
  }
}
