package model;

import java.util.StringTokenizer;


public class User {

  private int id;
  private String email;
  private String firstName;
  private String lastName;
  private String post;

  public User() {
        this.id=0;
        this.email="";
        this.firstName="";
        this.lastName="";
        this.post="";
    }
  public User(int Id,String Email , String FirstName, String LastName, String Post){
        this.id=Id;
        this.email=Email;
        this.firstName=FirstName;
        this.lastName=LastName;
        this.post=Post;

    }
  public User(String Email , String FirstName, String LastName, String Post){
        this.id=0;
        this.email=Email;
        this.firstName=FirstName;
        this.lastName=LastName;
        this.post=Post;

  }


    public int getId() {
        return this.id;
    }
    public String getEmail(){
        return this.email;
    }
    public String getLName(){
        return this.lastName;
    }
    public String getFName(){
        return this.firstName;
    }
    public String getPost()  {
        return this.post;
    }

    public void setUser(int Id,String Email,String FirstName,String LastName,String Post){
        this.id=Id;
        this.email=Email;
        this.firstName=FirstName;
        this.lastName=LastName;
        this.post=Post;
    }





}

