package poof.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

abstract class FileSystemEntity implements Serializable {
  private boolean mode;
  private String owner; 
  private String name;
 
  protected FileSystemEntity(String name, String owner){
    this.name = name; this.owner = owner; this.mode = false;}
    
  protected FileSystemEntity(String name, String owner, String mode){
    this.name = name; this.owner = owner;
    if(mode.equals("private")){this.mode = false; }
    else{ this.mode = true;}
  }  
 
  protected void setName(String name){this.name = name;}
  protected void setOwner(String owner){this.owner = owner;}
  protected void setMode(boolean mode){this.mode = mode;}
  
  protected String getName(){ return name;}
  protected String getOwner(){return owner;}
  protected boolean getMode(){return mode;}
  
  protected abstract String getAttributes();
  
  protected abstract int calcSize();
  protected abstract ArrayList<String> listEntry();
}
