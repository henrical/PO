package poof.core;

import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 */
class Directory extends FileSystemEntity implements Serializable{

  private Directory parent;
  private Map<String, FileSystemEntity> FSEList = new TreeMap<String, FileSystemEntity>();
  
  protected Directory(String name, String owner){
    super(name, owner);
    parent = this;
    
    FSEList.put(".", this);
    FSEList.put("..", parent);
    }
    
  protected Directory(String name, String owner, Directory parent)
  { 
    super(name, owner); this.parent = parent;
    FSEList.put(".", this);
    FSEList.put("..", parent);
    }
    
  protected Directory(String name, String owner, String mode, Directory parent)
  { 
    super(name, owner, mode); this.parent = parent;
    FSEList.put(".", this);
    FSEList.put("..", parent);
  }
  
  protected boolean entryExists(String name) 
  {
     return FSEList.containsKey(name);
  }
  
  protected FileSystemEntity getEntry(String name) 
  {
    return FSEList.get(name);
  }
  
  protected void addFSEntity(FileSystemEntity entity) 
    {
        FSEList.put(entity.getName(),entity);
    }
  
  protected void removeEntry(String name) throws UnknownEntryException
  {
      if(!FSEList.containsKey(name))
	{
	  throw new UnknownEntryException(name);
	}
      else FSEList.remove(name);
  }
  
  
  protected Directory getParent(){return parent;}
  protected int calcSize(){  return 8*FSEList.size();}
  
  protected ArrayList<String> listEntry(){
     ArrayList<String> list = new ArrayList<String>();

    for(Map.Entry<String, FileSystemEntity> entry : FSEList.entrySet())
    {
      list.add(entry.getValue().getAttributes() + entry.getKey());
    }
    
    return list;
  }
  
  protected String getAttributes(){  
    String perm;
    
    if(getMode()){perm = "w";} 
    else {perm = "-";}
   
    return "d " + perm + " " + getOwner() + " " + calcSize() + " ";
    }

    protected boolean entryIsDirectory(String name)
    {
	return (this.getEntry(name) instanceof Directory);
    }
}