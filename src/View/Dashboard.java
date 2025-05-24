/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends javax.swing.JFrame {

    public Dashboard() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        JLabel appTitle = new JLabel("Powerpay");
        JLabel profileLabel = new JLabel("Profile");

        JButton btnDashboard = new JButton("Dashboard");
        JButton btnAdvancePayment = new JButton("Advanced Payment");
        JButton btnHistory = new JButton("History");
        JButton btnSettings = new JButton("Settings");

        JLabel balanceTitle = new JLabel("BALANCE");
        JLabel balanceText = new JLabel("Current Balance");
        JLabel balanceAmount = new JLabel("Rs. 1250.00");

        JButton btnAdvance = new JButton("Advance Payment");
        JButton btnRequest = new JButton("Request Payment");

        JLabel dueLabel = new JLabel("Due Payments");

        JTable paymentTable = new JTable(new DefaultTableModel(
                new Object[][]{
                        {"Ishan", "Rs. 250", "Apr. 15 2025", "Pending"}
                },
                new String[]{"Name", "Amount", "Due Date", "Status"}
        ));
        JScrollPane tableScroll = new JScrollPane(paymentTable);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");

        // Styling
        appTitle.setFont(new java.awt.Font("Segoe UI", 1, 18));
        balanceAmount.setFont(new java.awt.Font("Segoe UI", 1, 20));

        // Layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Dashboard().setVisible(true));
    }
}
