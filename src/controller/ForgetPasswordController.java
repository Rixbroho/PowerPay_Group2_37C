package controller;

import Dao.UserDao;
import View.ChangePassword;
import View.ForgetPassword;
import View.SignUp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Controller.EmailController;


public class ForgetPasswordController {
    private final ForgetPassword view;
    private final UserDao userDao = new UserDao();
    
    public ForgetPasswordController(ForgetPassword view) {
        System.out.println("here");
        this.view = view;
        this.view.addSendCodeListener(new SendCodeListener());
        this.view.addCreateNewAccountListener(new CreateNewAccountListener());
        this.view.addVerifyCodeListener(new VerifyCodeListener());
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
            System.out.println("Clicked");
            String email = view.getEmailField().getText().trim();
            if (email.isEmpty() || email.equals("Email")) {
                JOptionPane.showMessageDialog(view, "Please enter your email.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            boolean userExists = userDao.checkMail(email);
            if (userExists) {
                boolean sent = Controller.EmailController.sendVerificationCode(email);
                if (sent) {
                    JOptionPane.showMessageDialog(view, "Code sent to your email by PowerPay!");
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
            System.out.println("Clicked on ");
            SignUp signUpView = new SignUp();
            SignupController signupController = new SignupController(signUpView);
            close();
            signupController.open();
        }
    }
    
    class VerifyCodeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Clicked on enter code");
            String email = view.getEmailField().getText().trim();
            String enteredCode = view.getCodeField().getText().trim();

            if (EmailController.verifyCode(email, enteredCode)) {
                JOptionPane.showMessageDialog(view, "Code is correct!");
                EmailController.clearCode(email);
                
                ChangePassword changeView = new ChangePassword();
                ChangePasswordController changeController = new ChangePasswordController(changeView, email);
                close(); // Close the forgot password window
                changeController.open();
                

                // You can now show reset password view
                // Or enable a "Next" button, etc.
            } else {
                JOptionPane.showMessageDialog(view, "Incorrect code.");
            }
        }
    }
}
