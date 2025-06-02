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
import View.LogIn;
import model.LoginRequest;
import View.Dashboard;
/**
 *
 * @author User
 */
public class LoginController {
    private final UserDao userDao = new UserDao();
    private final LogIn userView;

    public LoginController(LogIn userView) {
        this.userView = userView;
        userView.addLoginUserListener(new AddUserListener());
    }

    public void open() {
        this.userView.setVisible(true);
    }

    public void close() {
        this.userView.dispose();
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           try {
                // Collect email and password from the form
                String email = userView.getEmailField().getText();
                String password = new String(userView.getPasswordField().getPassword()); // Correct way for JPasswordField

                // Debugging output
                System.out.println("Login button clicked");
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);

                // Authenticate the user
                LoginRequest user = new LoginRequest(email, password);
                UserData loginUser = userDao.login(user);

                if (loginUser == null) {
                    JOptionPane.showMessageDialog(userView, "Invalid Credentials");
                } else {
                    JOptionPane.showMessageDialog(userView, "Login Successful");
                    Dashboard dashboard = new Dashboard();
                    dashboard.setVisible(true);
                    close();
                }
            } catch (Exception ex) {
                ex.printStackTrace(); // Better for debugging
                JOptionPane.showMessageDialog(userView, "Error: " + ex.getMessage());
            }
        }
    }
}
