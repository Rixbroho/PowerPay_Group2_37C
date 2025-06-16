package controller;

import Dao.UserDao;
import View.ForgetPassword;
import View.SignUp;
import View.LogIn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.UserData;

public class ForgetPasswordController {
    private final ForgetPassword view;
    private final UserDao userDao = new UserDao();
    
    public ForgetPasswordController(ForgetPassword view) {
        this.view = view;
        this.view.addSendCodeListener(new SendCodeListener());
        this.view.addCreateNewAccountListener(new CreateNewAccountListener());
        // add other listeners similarly
    }

    public void open() {
        view.setVisible(true);
    }

    public void close() {
        view.dispose();
    }

    class SendCodeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = view.getEmailField().getText().trim();
            if (email.isEmpty() || email.equals("Email")) {
                JOptionPane.showMessageDialog(view, "Please enter your email.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            boolean userExists = userDao.checkMail(email);
            if (userExists) {
                boolean sent = Controller.EmailController.sendVerificationCode(email);
                if (sent) {
                    JOptionPane.showMessageDialog(view, "Code sent to your email!");
                } else {
                    JOptionPane.showMessageDialog(view, "Failed to send code.");
                }
            } else {
                JOptionPane.showMessageDialog(view, "This email is not registered.");
            }
            
        }
    }

    class CreateNewAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SignUp signUpView = new SignUp();
            SignupController signupController = new SignupController(signUpView);
            close();
            signupController.open();
        }
    }
}
