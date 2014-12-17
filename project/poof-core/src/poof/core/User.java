package poof.core;

import java.io.Serializable;

class User implements Serializable {
  private String name;
  private String username;
  
  protected User(String username,String name){
    this.name = name; this.username = username;}  
    
  protected String getName(){return name;}
  protected String getUsername(){return username;}
  
  @Override
  public String toString() {return username + ":" + name + ":" + "/home/" + username;}
}