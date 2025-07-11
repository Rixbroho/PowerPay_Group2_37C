package controller;

import Dao.UserDao;
import View.AdminDashboards;
import View.ForgetPassword;
import View.UserDashboard;
import View.LogIn;
import View.SignUp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.LoginRequest;
import model.UserData;

public class LoginController {

    private final UserDao userDao = new UserDao();
    private final LogIn userView;

    public LoginController(LogIn userView) {
        this.userView = userView;
        this.userView.addLoginUserListener(new AddUserListener());
        this.userView.addSignUpListener(new SignUpListener());
        this.userView.addForgotPassword(new ForgotPassword());
    }

    public void open() {
        userView.setVisible(true);
    }

    public void close() {
        System.out.println("Closing login window...");
        userView.dispose();
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Login button clicked");
            try {
                String email = userView.getEmailField().getText().trim();
                String password = new String(userView.getPasswordField().getPassword()).trim();

                if (email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(userView, "Please enter both email and password");
                    return;
                }

                LoginRequest user = new LoginRequest(email, password);
                UserData loginUser = userDao.login(user);
                UserData loginAdmin=userDao.loginAdmin(user);

                if (loginUser != null) {
                    JOptionPane.showMessageDialog(userView, "Login Successful");
                    UserDashboard dashboard = new UserDashboard();
                    dashboard.setVisible(true);
                    close();
                    
                }else if (loginAdmin != null) {
                    JOptionPane.showMessageDialog(userView, "Login Successful");
                    AdminDashboards dashboard = new AdminDashboards();
                    dashboard.setVisible(true);
                    close();
                    
                }else {
                   JOptionPane.showMessageDialog(userView, "Invalid Credentials");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(userView, "An unexpected error occurred during login.");
                ex.printStackTrace();
            }
        }
    }
    
    class SignUpListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("click the sign up");
            SignUp signUpView = new SignUp();
            SignupController signupController = new SignupController(signUpView);
            close();  // close Login window
            signupController.open();  // open SignUp window
        }
    }
    
    class ForgotPassword implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("click the forgetpassword");
            ForgetPassword form = new ForgetPassword();
            ForgetPasswordController controller = new ForgetPasswordController(form);
            close();
            controller.open();
        }
    }
}

