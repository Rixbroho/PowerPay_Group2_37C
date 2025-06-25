/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import javax.swing.JButton;

/**
 *
 * @author Acer
 */
public class UserMngmt {
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String username;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String email;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private Date created_at;

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    private String phone_number;
    public String getPhone_number() { return phone_number; } 
    public void setPhone_number(String phone_number) { 
        this.phone_number = phone_number; 
    }
    
    private JButton addBillButton;
    public JButton getAddBillButton() { 
        return addBillButton; 
    }
    public void setAddBillButton(JButton addBillButton) {
        this.addBillButton = addBillButton; 
    }
    
    
    public UserMngmt(int id, String username, String email, Date created_at, String phone_number, JButton jButton){
        this.id = id;
        this.username = username;
        this.email = email;
        this.created_at = created_at;
        this.phone_number=phone_number;
        this.addBillButton = addBillButton;
    }
}
