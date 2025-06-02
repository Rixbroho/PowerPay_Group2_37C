/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Dao.UserDao;
import View.Dashboard;
import View.LogIn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.LoginRequest;
import model.UserData;
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
            System.out.println("Login button clicked");
            try {
                String email = userView.getEmailField().getText();
                String password = new String(userView.getPasswordField().getPassword());
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
                ex.printStackTrace(); // print the full error
            }
        }
    }
}
