package controller;

import Dao.UserDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.UserData;
import View.SignUp;
import View.LogIn;

public class SignupController {

    private final UserDao userDao = new UserDao();
    private final SignUp userView;

    public SignupController(SignUp userView) {
        this.userView = userView;
        this.userView.addAddUserListener(new AddUserListener());
        this.userView.addLoginListener(new LoginListener());
    }

    public void open() {
        userView.setVisible(true);
    }

    public void close() {
        userView.dispose();
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String username = userView.getUsernamefield().getText().trim();
                String email = userView.getEmailfield().getText().trim();
                String password = new String(userView.getPasswordfield().getPassword()).trim();
                String number = userView.getNumberfield().getText().trim();
                String userType = userView.getUserType();
                boolean keepLoggedIn = userView.getKeepLoggedInCheckBox().isSelected();

                StringBuilder emptyFields = new StringBuilder();
                if (username.isEmpty() || username.equalsIgnoreCase("Username")) emptyFields.append("Username, ");
                if (email.isEmpty() || email.equalsIgnoreCase("Email")) emptyFields.append("Email, ");
                if (password.isEmpty() || password.equalsIgnoreCase("password12345")) emptyFields.append("Password, ");
                if (number.isEmpty() || number.equalsIgnoreCase("Number")) emptyFields.append("Number, ");

                if (emptyFields.length() > 0) {
                    String fields = emptyFields.substring(0, emptyFields.length() - 2);
                    JOptionPane.showMessageDialog(userView, "Please fill in the following fields: " + fields);
                    return;
                }

                if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
                    JOptionPane.showMessageDialog(userView, "Invalid email format");
                    return;
                }

                if (!number.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(userView, "Phone number must be 10 digits");
                    return;
                }

                UserData userdata = new UserData(username, email, password, number, userType, keepLoggedIn);

                boolean userExists = userDao.checkUser(userdata);
                if (userExists) {
                    JOptionPane.showMessageDialog(userView, "User Already Exists");
                } else {
                    userDao.Createsignup(userdata);
                    JOptionPane.showMessageDialog(userView, "Sign Up Successful!");

                    LogIn loginView = new LogIn();
                    LoginController login = new LoginController(loginView);
                    close();
                    login.open();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(userView, "Error during signup. Please try again.");
                ex.printStackTrace();
            }
        }
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LogIn loginView = new LogIn();
            LoginController login = new LoginController(loginView);
            close();
            login.open();
        }
    }
}