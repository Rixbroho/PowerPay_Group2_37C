/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Dao.UserDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.UserData;
import View.SignUp;
import View.LogIn;
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
//        userView.addLoginListener(new LoginListener());
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
            try {
                String username = userView.getUsernamefield().getText().trim();
                String email = userView.getEmailfield().getText().trim();
                String password = new String(userView.getPasswordfield().getPassword()).trim();
                String number = userView.getNumberfield().getText().trim();
                String userType = userView.getUserType();  // From dropdown or similar
                boolean keepLoggedIn = userView.getKeepLoggedInCheckBox().isSelected();  // From checkbox

                // Validation for empty fields
                StringBuilder emptyFields = new StringBuilder();
                if (username.isEmpty() || username.equals("Username")) emptyFields.append("Username, ");
                if (email.isEmpty() || email.equals("Email")) emptyFields.append("Email, ");
                if (password.isEmpty() || password.equals("password12345")) emptyFields.append("Password, ");
                if (number.isEmpty() || number.equals("Number")) emptyFields.append("Number, ");

                if (emptyFields.length() > 0) {
                    // Remove last comma and space
                    String fields = emptyFields.substring(0, emptyFields.length() - 2);
                    JOptionPane.showMessageDialog(userView, "Please fill in the following fields: " + fields);
                    return;  // stop further execution
                }

                UserData userdata = new UserData(username, email, password, number,userType,keepLoggedIn);
                boolean check = userDao.checkUser(userdata);
                if (check) {
                    JOptionPane.showMessageDialog(userView, "User Already Exists");
                } else {
                    userDao.signUp(userdata);
                    JOptionPane.showMessageDialog(userView, "Sign Up Successful!");
                }
            }catch (Exception ex) {
                System.out.println("Error Adding User: " + ex.getMessage());
            }
        }
    }
    
//    class LoginListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            LogIn loginView = new LogIn();
//            LogInController login = new LogInController(loginView);
//            close();
//            login.open();
//        }
//    }
    
}