package poof.core;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.ArrayList;

/**
  * Class <code>FileSystem</code> represents a Filesystem made of entities
  * that can either be Files (<code>File</code>) or Directories (<code>Directory</code>)
  * or some other type defined later without changes to storage and access to said entities
  */

class FileSystem implements Serializable{
  /**
    * Map containing all current known users
    */
  private Map<String, User> users = new TreeMap<String, User>();
  /**
    * Root of the Filesystem and contains all files and directories
    */
  private Directory rootDir = new Directory("raiz", "root");
  /**
    * Name of the file to serialize the Filesystem in
    */
  private String saveFile = "";
  
  /**
    * Keeps track of the changes made to the filesystem
    */
  private boolean hasChanged;
  
  protected FileSystem(){
    hasChanged = true;
    User root = new User("root", "super user");
    users.put("root", root);
    
    /*create a /home/root path -> /  home / root */
    
    Directory home = new Directory("home", "root", rootDir);
    Directory rootHome = new Directory("root", "root", home);
    
    home.addFSEntity(rootHome);
    rootDir.addFSEntity(home);
  }
  
  /**
    * @param username username of the user to retrieve
    * @return user with specified username
    */
  protected User getUser(String username) 
  {
    return users.get(username);
  }
  /**
    *@return return the file to which the object should be serialized
    */
  protected String getSaveFile()
  {
    hasChanged = false;
    return saveFile;
  }
  
  protected void setSaveFile(String fileName)
  {
    saveFile = fileName;
  }
  
  /**
    * @return root of the Filesystem
    */
  protected Directory getRoot()
  {
      return rootDir;
  }
  /**
    *@return if the system has had a change or not
    */
  protected boolean getHasChanged(){return hasChanged;}
  
  /**
    * @param username username of the user's
    * @return home directory of the specified user
    */
  protected Directory getUserHome(String username)
  {
      Directory dir = (Directory)rootDir.getEntry("home"); //we are sure the FileSystemEntity returned is a directory, the cast does not cause information loss
      
      dir = (Directory)dir.getEntry(username);
      return dir;
  }
	    
  /**
    * Adds both user and that user's home folder
    *
    * @param user user to add to attribute users
    */
  protected void addUser(User user) 
  {
    users.put(user.getUsername(), user);
    
    Directory dir = (Directory)rootDir.getEntry("home");
    Directory userDir = new Directory(user.getUsername(), user.getUsername(), dir);
    dir.addFSEntity(userDir);
    hasChanged = true;
  }
  
  /**
    * @param username username of the user to verify if exists
    * @return true if exists, false otherwise 
    */  
  protected boolean checkUser(String username){ return users.containsKey(username);}
  
  /**
    * @param name name of the entry to remove
    * @param currentDir Directory where the entry is located
    */
  protected void removeEntry(String name, Directory currentDir) throws UnknownEntryException
  { 
    hasChanged = true; 
    currentDir.removeEntry(name);  
   }
  
  /**
    * @param name name of the file
    * @param username file's owner username
    * @param currentDir Directory where the file is to be created
    */
  protected void createFile(String name, String username, Directory currentDir)
  {
    hasChanged = true; currentDir.addFSEntity(new File(name, username));
  }
  
  /**
    * Only to be used when initializing the filesystem by text files
    * Travels to the directory and creates the file
    * @param path path to the file
    * @param name name of the file
    * @param owner file's owner username
    * @param mode either public or private; type of access
    * @param text text of the files
    *
    * @see directorySearch(String)
    */
  protected void createFile(String path, String name, String owner, String mode, String text) //usada pelo open
  {
    hasChanged = true;
    Directory dir = directorySearch(path);
    dir.addFSEntity(new File(name, owner, mode, text));
  }
  
  /**
    * @param name name of the Directory
    * @param username file's owner username
    * @param currentDir Directory where the file is to be created
    */
  protected void createDirectory(String name, String username, Directory currentDir)
  {
       hasChanged = true;
       currentDir.addFSEntity(new Directory(name, username, currentDir));
  }
  
  /**
    * Only to be used when initializing the filesystem by text files
    * Travels through and creates directories
    * @param path path to the file
    * @param name name of the file
    * @param owner file's owner username
    * @param mode either public or private; type of access
    */
  protected void createDirectory(String path, String name, String owner, String mode)
  {
      String args[] = path.split("/");
      Directory dir = rootDir, newDir;
      
      hasChanged = true;
      
      for(String s : args){
	if(s.equals(""))
	{
	  continue;
	}
	if(!dir.entryExists(s))
	{
	  newDir = new Directory(s, owner, mode, dir);
	  dir.addFSEntity(newDir);
	  dir = newDir;
	}
	else
	{
	  dir = (Directory)dir.getEntry(s);
	}
	
      }
  }
  
  /**
    *@param name name of the file to write to
    *@param text text to write
    *@param currentDir current Directory of the file
    */
  protected void writeFile(String name, String text, Directory currentDir){
    hasChanged = true;
    ((File)getEntry(name,currentDir)).write(text); 
  }
  
  /**
    *@param name name of the file to read from
    *@param currentDir current Directory of the file
    */
  protected String readFile(String name, Directory currentDir){
    return ((File)getEntry(name,currentDir)).read();
  }
  
  /**
    *@param name name of the file to change permission
    *@param mode type of access; public or private
    *@param currentDir current Directory of the entry
    */
  protected void changePermission(String name, String mode, Directory currentDir){
    hasChanged = true;
    
    if(mode == "private"){
      getEntry(name,currentDir).setMode(false);
      }
    else {
      getEntry(name,currentDir).setMode(true);
    }
  }
  
  /**
    *@param name name of the file to change owner
    *@param username new file owner
    *@param currentDir current Directory of the file
    */
  protected void changeOwner(String name, String username, Directory currentDir)
  {
    hasChanged = true;
    getEntry(name,currentDir).setOwner(username);
  }
  
  /**
    * Lists all known users
    */
  protected ArrayList<String> listUsers()
  {
    ArrayList<String> list = new ArrayList<String>();
    
    for(Map.Entry<String, User> entry : users.entrySet())
    {
	list.add(entry.getValue().toString());
    }
    return list;
  }
  
  /**
    *@param name name of the entry to list
    *@param currentDir current Directory of the entry
    */
  protected ArrayList<String> listEntry(String name, Directory currentDir)
  {
      return getEntry(name,currentDir).listEntry();
  }
  
  protected FileSystemEntity getEntry(String name, Directory currentDir)
   {
      return currentDir.getEntry(name);
   }
  
  /**
    * Lists all entries in currentDir
    *@param currentDir Directory to be listed
    */
  protected ArrayList<String> listEntries(Directory currentDir){return currentDir.listEntry();}
  
  protected String getEntryAttributes(String name, Directory currentDir)
  {
    String result = getEntry(name,currentDir).getAttributes() + getEntry(name, currentDir).getName();
    return result;
  }
  
  /**
    *Prints path from root to currDir
    *@param currDir current working Directory
    */
  protected String getCurrentPath(Directory currDir)
  {
      java.util.ArrayList<String> names = new java.util.ArrayList<String>();
      String path = "";
      int i = 0;
      
      while(currDir.getParent() != currDir)
      {
	names.add(currDir.getName());
	currDir = currDir.getParent();
      }
      
      java.util.Collections.reverse(names);
      
      for(String name : names)
      {
	path += "/" + name;
      }
      
      if(path.equals(""))
      {
	path = "/";
      }
      
     return path;
  }
  
  public boolean hasSaveFile()
  {
    return !saveFile.equals("");
  }
  
  /**
   * Auxiliary method
   *
   * returns a reference to the directory where we want to create an entity
   *
   * given "/usr/share/java" returns a reference to "share"
   *
   */
  public Directory directorySearch(String path)
  {
   String directories[] = path.split("/");
  
   int i = 1;
   int size = directories.length-2;
   Directory currDir = this.rootDir;
   
   while( i <= size )
   {
      if(!((currDir.getEntry(directories[i])) instanceof Directory))
	  {
	     return null; //MIGHT BE EXCEPTION
	  }
      currDir = (Directory)(currDir.getEntry(directories[i]));
      i++;
   }
   
   return currDir;
   
  }
  
  protected String listUserDirectory(String username)
  {
    Directory currentDir = (Directory)(rootDir.getEntry("home"));
    currentDir = (Directory)(currentDir.getEntry(username));
    
    return currentDir.getAttributes();
    
  }
  
  
}