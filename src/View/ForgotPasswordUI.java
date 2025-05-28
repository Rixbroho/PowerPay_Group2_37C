package View;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ForgotPasswordUI {
    private static String sentCode = "";

    public static void main(String[] args) {
        // Set FlatLaf theme
        JFrame frame = new JFrame("Forgot Password - PowerPay");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(5, 30, 60));
        frame.setLayout(null);

        ImageIcon rawIcon = new ImageIcon("/Users/rubinmaharjan/Documents/PowerPay_Group2_37C/src/Image/494327672_2092440944499081_5739252673242155345_n.jpg");
Image scaled = rawIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Resize
ImageIcon scaledIcon = new ImageIcon(scaled);

JLabel logoLabel = new JLabel(scaledIcon);
logoLabel.setBounds(200, 20, 100, 100); // Centered on top
frame.add(logoLabel);


        JLabel title = new JLabel("Forgot password", SwingConstants.CENTER);
title.setBounds(140, 122, 220, 30); // moved down by 30px

        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(new Color(145, 202, 255));
        frame.add(title);

        JTextField emailField = new JTextField("Email");
        emailField.setBounds(100, 150, 300, 40);
        emailField.setBackground(new Color(189, 226, 226));
        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(emailField);

        JButton sendCodeBtn = new JButton("Send Code");
        sendCodeBtn.setBounds(160, 210, 180, 40);
        sendCodeBtn.setBackground(new Color(51, 72, 178));
        sendCodeBtn.setForeground(Color.WHITE);
        sendCodeBtn.setFocusPainted(false);
        sendCodeBtn.setFont(new Font("Arial", Font.BOLD, 18));
        
        frame.add(sendCodeBtn);

        int boxWidth = 40;
        int gap = 10;
        int startX = (500 - (boxWidth * 6 + gap * 5)) / 2;
        JTextField[] otpFields = new JTextField[6];

        for (int i = 0; i < 6; i++) {
            otpFields[i] = new JTextField();
            otpFields[i].setBounds(startX + i * (boxWidth + gap), 270, boxWidth, 40);
            otpFields[i].setFont(new Font("Arial", Font.BOLD, 20));
            otpFields[i].setHorizontalAlignment(JTextField.CENTER);
            frame.add(otpFields[i]);
        }

        JCheckBox keepLoggedIn = new JCheckBox("Keep me logged in");
        keepLoggedIn.setBounds(160, 330, 200, 30);
        keepLoggedIn.setBackground(new Color(5, 30, 60));
        keepLoggedIn.setForeground(Color.WHITE);
        frame.add(keepLoggedIn);

        JButton enterCodeBtn = new JButton("Enter Code");
        enterCodeBtn.setBounds(160, 380, 180, 40);
        enterCodeBtn.setBackground(new Color(61, 82, 185));
        enterCodeBtn.setForeground(Color.WHITE);
        enterCodeBtn.setFocusPainted(false);
        enterCodeBtn.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(enterCodeBtn);

        JLabel orLabel = new JLabel("or", SwingConstants.CENTER);
        orLabel.setBounds(240, 440, 30, 20);
        orLabel.setForeground(Color.LIGHT_GRAY);
        frame.add(orLabel);

        JSeparator line1 = new JSeparator(SwingConstants.HORIZONTAL);
        line1.setBounds(100, 450, 120, 2);
        line1.setForeground(Color.GRAY);  // Visible on dark background
        line1.setBackground(Color.GRAY);
        frame.add(line1);


        JSeparator line2 = new JSeparator(SwingConstants.HORIZONTAL);
        line2.setBounds(280, 450, 120, 2);
        line2.setForeground(Color.GRAY);
        line2.setBackground(Color.GRAY);
        frame.add(line2);
        
        JLabel createAccount = new JLabel("Don’t have a account ? ");
        createAccount.setBounds(140, 480, 200, 30);
        createAccount.setForeground(Color.LIGHT_GRAY);
        frame.add(createAccount);

        JLabel createNow = new JLabel("Create yours now.");
        createNow.setBounds(300, 480, 200, 30);
        createNow.setForeground(Color.PINK);
        createNow.setFont(new Font("Arial", Font.BOLD, 12));
        frame.add(createNow);
        
        
        // Action: Send Code
        sendCodeBtn.addActionListener(e -> {
            String email = emailField.getText().trim();
            if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid email.");
                return;
            }

            sentCode = String.format("%06d", new Random().nextInt(1000000));
            System.out.println("🔐 Simulated sending OTP to " + email + ": " + sentCode);
            JOptionPane.showMessageDialog(frame, "Code sent to email! (Simulated)");
        });

        // Action: Enter Code
        enterCodeBtn.addActionListener(e -> {
            StringBuilder enteredCode = new StringBuilder();
            for (JTextField field : otpFields) {
                String digit = field.getText().trim();
                if (digit.isEmpty() || digit.length() != 1 || !digit.matches("[0-9]")) {
                    JOptionPane.showMessageDialog(frame, "Please fill all OTP boxes with valid digits.");
                    return;
                }
                enteredCode.append(digit);
            }

            if (enteredCode.toString().equals(sentCode)) {
                JOptionPane.showMessageDialog(frame, "✅ Code verified successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "❌ Incorrect code. Try again.");
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
