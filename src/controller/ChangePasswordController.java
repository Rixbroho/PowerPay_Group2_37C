package controller;

import Dao.UserDao;
import View.ChangePassword;
import View.LogIn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ChangePasswordController {
    private final ChangePassword view;
    private final String userEmail;
    private final UserDao userDao = new UserDao();

    public ChangePasswordController(ChangePassword view,String userEmail){
        this.view = view;
        this.userEmail=userEmail;
        
        this.view.addSubmitButtonListener(new SubmitListener());
    }

    public void open() {
        view.setVisible(true);
    }

    public void close() {
        view.dispose();
    }

    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String newPassword = view.getNewPasswordField().getText().trim();
            String confirmPassword = view.getConfirmPasswordField().getText().trim();

            if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Please fill in all fields.");
                return;
            }

            if (!newPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(view, "Passwords do not match.");
                return;
            }

            boolean updated = userDao.updatePassword(userEmail, newPassword);
            if (updated) {
                JOptionPane.showMessageDialog(view, "Password changed successfully.");
                LogIn log=new LogIn();
                LoginController controller=new LoginController(log);
                controller.open();
                close();
            } else {
                JOptionPane.showMessageDialog(view, "Failed to update password.");
            }
        }
    }
}
