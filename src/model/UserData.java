/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class UserData {
    private int id;
    private String username;
    private String email;
    private String password;
    private String number;
//    private String userType; // "Admin" or "User"
    private boolean keepLoggedIn;

    
    public UserData (String username,String email,String password,String number,boolean keepLoggedIn){
        this.username=username;
        this.email=email;
        this.password=password;
        this.number=number;
//        this.userType = userType;
        this.keepLoggedIn = keepLoggedIn;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }  
    
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    
    public String getNumber(){
        return number;
    }
    public void setNumber(String number){
        this.number=number;
    }
    
//    public String getUserType() {
//        return userType;
//    }
//    public void setUserType(String userType) {
//        this.userType = userType;
//    }

    public boolean getKeepLoggedIn() {
        return keepLoggedIn;
    }
    public void setKeepLoggedIn(boolean keepLoggedIn) {
        this.keepLoggedIn = keepLoggedIn;
    }
    
}
