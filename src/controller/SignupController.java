/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Dao.UserDao;



import View.SignUp;
import Dao.UserDao;
import View.SignUp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.UserData;

/**
 *
 * @author User
 */

public class SignupController {
    private final UserDao userDao = new UserDao();
    private final SignUp userView;
    public SignupController(SignUp userView) {
        this.userView = userView;
        userView.addAddUserListener(new AddUserListener());
    }
    public void open() {
        this.userView.setVisible(true);
    }
    public void close() {
        this.userView.dispose();
    }
     class AddUserListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            UserDao userDao = new UserDao();
            try{
                String username = userView.getUsernamefield().getText();
                String email = userView.getEmailfield().getText();
                String password = userView.getPasswordfield().getText();
                String number = userView.getNumberfield().getText();
                UserData userdata = new UserData(username,email,password,number);
                boolean check = userDao.checkUser(userdata);
                if(check){
                    JOptionPane.showMessageDialog(userView,"User Already Exists");
                }else{
                    userDao.signUp(userdata);
                }
            }catch(Exception ex){
                System.out.println("Error Adding User"+ ex.getMessage());
            }
        }
}
}