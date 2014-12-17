package poof.core;

import java.util.ArrayList;
import java.io.Serializable;

class File extends FileSystemEntity implements Serializable{
  private String text = "";
  
  protected File(String name, String username, String mode, String text){
    super(name, username, mode);
    this.text = text;
  }
  
  protected File(String name, String username){
    super(name, username);
  }
  
  protected File(String name, String username, String mode){
    super(name, username, mode);
  }

  protected String read(){  return text;}
  protected void write(String text)
  { 
      String fileText = this.text;
      if(fileText.equals(""))
      {
	  this.text = text;
      }
      else
      {
          this.text += "\n";
	  this.text += text;
	  ;
      }
  }
  
  protected int calcSize(){ 
      int length = text.length();
      if(text.equals(""))
      {
	  return 0;
      }
      else
      {
	  return length + 1;
      }
  }
  
  protected ArrayList<String> listEntry()
  {
    ArrayList<String> list = new ArrayList<String>();
    
    list.add(getAttributes() + " " + getName());
    
    return list;
  }
    
  protected String getAttributes() {
    String perm;
    
    if(getMode()){perm = "w";}
    else {perm = "-";}
  
    return "-" + " " + perm + " " + getOwner() + " " + calcSize() + " ";}
  
}