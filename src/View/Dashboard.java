package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Dashboard extends javax.swing.JFrame {

    public Dashboard() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Set main background color
        Color bgColor = new Color(0, 30, 63);
        Color textColor = Color.WHITE;
        Color accentColor = new Color(70, 130, 180); // Optional accent color

        JPanel contentPane = new JPanel();
        contentPane.setBackground(bgColor);
        setContentPane(contentPane);

        JLabel appTitle = new JLabel("Powerpay");
        appTitle.setForeground(textColor);
        appTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));

        JLabel profileLabel = new JLabel("Profile");
        profileLabel.setForeground(textColor);

        JButton btnDashboard = new JButton("Dashboard");
        JButton btnAdvancePayment = new JButton("Advanced Payment");
        JButton btnHistory = new JButton("History");
        JButton btnSettings = new JButton("Settings");

        for (JButton button : new JButton[]{btnDashboard, btnAdvancePayment, btnHistory, btnSettings}) {
            button.setBackground(accentColor);
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
        }

        JLabel balanceTitle = new JLabel("BALANCE");
        balanceTitle.setForeground(textColor);
        balanceTitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        JLabel balanceText = new JLabel("Current Balance");
        balanceText.setForeground(textColor);

        JLabel balanceAmount = new JLabel("Rs. 1250.00");
        balanceAmount.setForeground(Color.GREEN);
        balanceAmount.setFont(new Font("Segoe UI", Font.BOLD, 24));

        JButton btnAdvance = new JButton("Advance Payment");
        JButton btnRequest = new JButton("Request Payment");

        for (JButton button : new JButton[]{btnAdvance, btnRequest}) {
            button.setBackground(new Color(30, 144, 255));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
        }

        JLabel dueLabel = new JLabel("Due Payments");
        dueLabel.setForeground(textColor);
        dueLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JTable paymentTable = new JTable(new DefaultTableModel(
                new Object[][]{
                        {"Ishan", "Rs. 250", "Apr. 15 2025", "Pending"}
                },
                new String[]{"Name", "Amount", "Due Date", "Status"}
        ));
        paymentTable.setFillsViewportHeight(true);
        paymentTable.setBackground(Color.WHITE);
        JScrollPane tableScroll = new JScrollPane(paymentTable);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");

        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(appTitle)
                                .addGap(200, 300, Short.MAX_VALUE)
                                .addComponent(profileLabel))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDashboard)
                                .addComponent(btnAdvancePayment)
                                .addComponent(btnHistory)
                                .addComponent(btnSettings))
                        .addComponent(balanceTitle)
                        .addComponent(balanceText)
                        .addComponent(balanceAmount)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdvance)
                                .addComponent(btnRequest))
                        .addComponent(dueLabel)
                        .addComponent(tableScroll)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(appTitle)
                                .addComponent(profileLabel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnDashboard)
                                .addComponent(btnAdvancePayment)
                                .addComponent(btnHistory)
                                .addComponent(btnSettings))
                        .addComponent(balanceTitle)
                        .addComponent(balanceText)
                        .addComponent(balanceAmount)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAdvance)
                                .addComponent(btnRequest))
                        .addComponent(dueLabel)
                        .addComponent(tableScroll)
        );

        pack();
        setLocationRelativeTo(null); // Center the window
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Dashboard().setVisible(true));
    }
}
