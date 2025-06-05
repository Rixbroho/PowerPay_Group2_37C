
package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Daashboard
     */
    public Dashboard() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 51));


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


        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField6.setText("Current Balance");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });


        for (JButton button : new JButton[]{btnAdvance, btnRequest}) {
            button.setBackground(new Color(30, 144, 255));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
        }

        JLabel dueLabel = new JLabel("Due Payments");
        dueLabel.setForeground(textColor);
        dueLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));


        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Dashboard");

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Advance Payment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("History");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("Settings");

        jButton5.setBackground(new java.awt.Color(204, 204, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("Advance Payment");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(204, 204, 255));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setText("Request Payment");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField2.setText("Due Payments");

        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField3.setText("Profile");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Ishan", "Rs. 250", "Apr. 15 2025", "Pending"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Amount", "Due Date", "Status"
            }
        ));

        paymentTable.setFillsViewportHeight(true);
        paymentTable.setBackground(Color.WHITE);
        JScrollPane tableScroll = new JScrollPane(paymentTable);


        jLabel1.setText("PowerPay");
        jLabel1.setOpaque(true);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null); // Center the window
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
