/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import controller.UserMngmtController;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;

/**
 *
 * @author User
 */
public class AdminDashboards extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashboards
     */
    public AdminDashboards() {
        initComponents();
        initComponents();
        showPieChart();
        showLineChart();
        showHistogram();
        showBarChart();
    }
    
    public void showPieChart(){
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      barDataset.setValue( "Elericity" , new Double( 20 ) );  
      barDataset.setValue( "Internet" , new Double( 20 ) );   
      barDataset.setValue( "Life Insurance" , new Double( 60 ) );    
      barDataset.setValue( "Water Bill" , new Double( 90 ) );  
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Money Use",barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("Elericity", new Color(255,255,102));
        piePlot.setSectionPaint("Internet", new Color(102,255,102));
        piePlot.setSectionPaint("Life Insurance", new Color(255,102,153));
        piePlot.setSectionPaint("Water Bill", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        PieChart.removeAll();
        PieChart.add(barChartPanel, BorderLayout.CENTER);
        PieChart.validate();
    }
    
     public void showLineChart(){
        //create dataset for the graph
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "january");
        dataset.setValue(150, "Amount", "february");
        dataset.setValue(18, "Amount", "march");
        dataset.setValue(100, "Amount", "april");
        dataset.setValue(80, "Amount", "may");
        dataset.setValue(250, "Amount", "june");
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("Spent","monthly","amount", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204,0,51);
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        LineChart.removeAll();
        LineChart.add(lineChartPanel, BorderLayout.CENTER);
        LineChart.validate();
    }
     
    public void showHistogram(){
        
         double[] values = { 95, 49, 14, 59, 50, 66, 47, 40, 1, 67,
                            12, 58, 28, 63, 14, 9, 31, 17, 94, 71,
                            49, 64, 73, 97, 15, 63, 10, 12, 31, 62,
                            93, 49, 74, 90, 59, 14, 15, 88, 26, 57,
                            77, 44, 58, 91, 10, 67, 57, 19, 88, 84                                
                          };
 
 
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("key", values, 20);
        
         JFreeChart chart = ChartFactory.createHistogram("JFreeChart Histogram","Data", "Frequency", dataset,PlotOrientation.VERTICAL, false,true,false);
            XYPlot plot= chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);

        
        
        ChartPanel barpChartPanel2 = new ChartPanel(chart);
        Histogram.removeAll();
        Histogram.add(barpChartPanel2, BorderLayout.CENTER);
        Histogram.validate();
    }

    /*========================================================================================*/
    
    public void showBarChart(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "january");
        dataset.setValue(150, "Amount", "february");
        dataset.setValue(18, "Amount", "march");
        dataset.setValue(100, "Amount", "april");
        dataset.setValue(80, "Amount", "may");
        dataset.setValue(250, "Amount", "june");
        
        JFreeChart chart = ChartFactory.createBarChart("contribution","monthly","amount", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204,0,51);
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        BarChart.removeAll();
        BarChart.add(barpChartPanel, BorderLayout.CENTER);
        BarChart.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        History_btn = new javax.swing.JLabel();
        Dashboard_btn = new javax.swing.JLabel();
        Setting_btn = new javax.swing.JLabel();
        UserList_btn = new javax.swing.JLabel();
        Reports_btn = new javax.swing.JLabel();
        Reports_btn1 = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Parent = new javax.swing.JPanel();
        Dashboard = new javax.swing.JPanel();
        Currentbalance = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        DuePayment = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        UserList = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        DuePayment1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        History = new javax.swing.JPanel();
        DuePayment2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        Reports = new javax.swing.JPanel();
        PieChart = new javax.swing.JPanel();
        LineChart = new javax.swing.JPanel();
        Reports2 = new javax.swing.JPanel();
        Histogram = new javax.swing.JPanel();
        BarChart = new javax.swing.JPanel();
        Setting = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        showPassword = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1010, 800));
        getContentPane().setLayout(null);

        main.setBackground(new java.awt.Color(8, 26, 50));
        main.setPreferredSize(new java.awt.Dimension(900, 800));

        jPanel3.setBackground(new java.awt.Color(10, 30, 58));
        jPanel3.setLayout(null);

        History_btn.setFont(new java.awt.Font("Segoe UI Emoji", 1, 13)); // NOI18N
        History_btn.setForeground(new java.awt.Color(255, 255, 255));
        History_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-history-20.png"))); // NOI18N
        History_btn.setText("History");
        History_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        History_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                History_btnMouseClicked(evt);
            }
        });
        jPanel3.add(History_btn);
        History_btn.setBounds(320, 0, 100, 50);

        Dashboard_btn.setFont(new java.awt.Font("Segoe UI Emoji", 1, 13)); // NOI18N
        Dashboard_btn.setForeground(new java.awt.Color(255, 255, 255));
        Dashboard_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dashboard.png"))); // NOI18N
        Dashboard_btn.setText("Dashboard");
        Dashboard_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Dashboard_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Dashboard_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Dashboard_btnMouseEntered(evt);
            }
        });
        jPanel3.add(Dashboard_btn);
        Dashboard_btn.setBounds(40, 0, 110, 50);

        Setting_btn.setFont(new java.awt.Font("Segoe UI Emoji", 1, 13)); // NOI18N
        Setting_btn.setForeground(new java.awt.Color(255, 255, 255));
        Setting_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-setting-20.png"))); // NOI18N
        Setting_btn.setText("Setting ");
        Setting_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Setting_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Setting_btnMouseClicked(evt);
            }
        });
        jPanel3.add(Setting_btn);
        Setting_btn.setBounds(690, 0, 110, 50);

        UserList_btn.setFont(new java.awt.Font("Segoe UI Emoji", 1, 13)); // NOI18N
        UserList_btn.setForeground(new java.awt.Color(255, 255, 255));
        UserList_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-bank-cards-20.png"))); // NOI18N
        UserList_btn.setText("User Details");
        UserList_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserList_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserList_btnMouseClicked(evt);
            }
        });
        jPanel3.add(UserList_btn);
        UserList_btn.setBounds(180, 0, 100, 50);

        Reports_btn.setFont(new java.awt.Font("Segoe UI Emoji", 1, 13)); // NOI18N
        Reports_btn.setForeground(new java.awt.Color(255, 255, 255));
        Reports_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-pie-chart-20.png"))); // NOI18N
        Reports_btn.setText("Reports ");
        Reports_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Reports_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Reports_btnMouseClicked(evt);
            }
        });
        jPanel3.add(Reports_btn);
        Reports_btn.setBounds(430, 0, 110, 50);

        Reports_btn1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 13)); // NOI18N
        Reports_btn1.setForeground(new java.awt.Color(255, 255, 255));
        Reports_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-pie-chart-20.png"))); // NOI18N
        Reports_btn1.setText("Reports ");
        Reports_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Reports_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Reports_btn1MouseClicked(evt);
            }
        });
        jPanel3.add(Reports_btn1);
        Reports_btn1.setBounds(560, 0, 110, 50);

        Header.setBackground(new java.awt.Color(8, 26, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PowerPay");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 811, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Parent.setLayout(new java.awt.CardLayout());

        Dashboard.setBackground(new java.awt.Color(5, 23, 46));

        Currentbalance.setBackground(new java.awt.Color(10, 30, 58));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-wallet-100.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Total Balance");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Rs");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(204, 204, 204));
        jLabel31.setText("1200.00");

        javax.swing.GroupLayout CurrentbalanceLayout = new javax.swing.GroupLayout(Currentbalance);
        Currentbalance.setLayout(CurrentbalanceLayout);
        CurrentbalanceLayout.setHorizontalGroup(
            CurrentbalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CurrentbalanceLayout.createSequentialGroup()
                .addGroup(CurrentbalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CurrentbalanceLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31))
                    .addGroup(CurrentbalanceLayout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel10))
                    .addGroup(CurrentbalanceLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel9)))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        CurrentbalanceLayout.setVerticalGroup(
            CurrentbalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CurrentbalanceLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CurrentbalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel31))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(10, 30, 58));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-add-20.png"))); // NOI18N
        jLabel7.setText("Quick Action");

        jButton3.setBackground(new java.awt.Color(68, 104, 150));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Add Bill");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setEnabled(false);
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addGap(41, 41, 41)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        DuePayment.setBackground(new java.awt.Color(10, 30, 58));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 204));
        jLabel26.setText("Total Admin");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 204, 204));
        jLabel28.setText("Total Payments");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 204, 204));
        jLabel29.setText("Total Users");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 204, 204));
        jLabel30.setText("Pending Payment");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("1200");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(204, 204, 204));
        jLabel32.setText("1200");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(204, 204, 204));
        jLabel33.setText("1200");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(204, 204, 204));
        jLabel34.setText("1");

        javax.swing.GroupLayout DuePaymentLayout = new javax.swing.GroupLayout(DuePayment);
        DuePayment.setLayout(DuePaymentLayout);
        DuePaymentLayout.setHorizontalGroup(
            DuePaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DuePaymentLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(DuePaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel34))
                .addGap(79, 79, 79)
                .addGroup(DuePaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel12))
                .addGap(79, 79, 79)
                .addGroup(DuePaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(DuePaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel33))
                .addGap(124, 124, 124))
        );
        DuePaymentLayout.setVerticalGroup(
            DuePaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DuePaymentLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(DuePaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addGap(28, 28, 28)
                .addGroup(DuePaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DashboardLayout = new javax.swing.GroupLayout(Dashboard);
        Dashboard.setLayout(DashboardLayout);
        DashboardLayout.setHorizontalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DuePayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DashboardLayout.createSequentialGroup()
                        .addComponent(Currentbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashboardLayout.setVerticalGroup(
            DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(DashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Currentbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(DuePayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        Parent.add(Dashboard, "card2");

        UserList.setBackground(new java.awt.Color(5, 23, 46));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("User List");

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "S.N", "Name", "Email", "Created_at", "Add bill"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(userTable);

        javax.swing.GroupLayout DuePayment1Layout = new javax.swing.GroupLayout(DuePayment1);
        DuePayment1.setLayout(DuePayment1Layout);
        DuePayment1Layout.setHorizontalGroup(
            DuePayment1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
        );
        DuePayment1Layout.setVerticalGroup(
            DuePayment1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout UserListLayout = new javax.swing.GroupLayout(UserList);
        UserList.setLayout(UserListLayout);
        UserListLayout.setHorizontalGroup(
            UserListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserListLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel8)
                .addContainerGap(824, Short.MAX_VALUE))
            .addGroup(UserListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(UserListLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(DuePayment1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );
        UserListLayout.setVerticalGroup(
            UserListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserListLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(536, Short.MAX_VALUE))
            .addGroup(UserListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(UserListLayout.createSequentialGroup()
                    .addGap(129, 129, 129)
                    .addComponent(DuePayment1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(170, Short.MAX_VALUE)))
        );

        Parent.add(UserList, "card3");

        History.setBackground(new java.awt.Color(8, 26, 50));

        DuePayment2.setBackground(new java.awt.Color(10, 30, 58));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("History");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Due Date", "Amout", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout DuePayment2Layout = new javax.swing.GroupLayout(DuePayment2);
        DuePayment2.setLayout(DuePayment2Layout);
        DuePayment2Layout.setHorizontalGroup(
            DuePayment2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DuePayment2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
        );
        DuePayment2Layout.setVerticalGroup(
            DuePayment2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DuePayment2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HistoryLayout = new javax.swing.GroupLayout(History);
        History.setLayout(HistoryLayout);
        HistoryLayout.setHorizontalGroup(
            HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HistoryLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(DuePayment2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        HistoryLayout.setVerticalGroup(
            HistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HistoryLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(DuePayment2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        Parent.add(History, "card4");

        Reports.setBackground(new java.awt.Color(8, 26, 50));

        PieChart.setBackground(new java.awt.Color(10, 30, 58));
        PieChart.setLayout(new java.awt.BorderLayout());

        LineChart.setBackground(new java.awt.Color(10, 30, 58));
        LineChart.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout ReportsLayout = new javax.swing.GroupLayout(Reports);
        Reports.setLayout(ReportsLayout);
        ReportsLayout.setHorizontalGroup(
            ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportsLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(PieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(LineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );
        ReportsLayout.setVerticalGroup(
            ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportsLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LineChart, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(PieChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        Parent.add(Reports, "card5");

        Reports2.setBackground(new java.awt.Color(8, 26, 50));

        Histogram.setBackground(new java.awt.Color(10, 30, 58));
        Histogram.setLayout(new java.awt.BorderLayout());

        BarChart.setBackground(new java.awt.Color(10, 30, 58));
        BarChart.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout Reports2Layout = new javax.swing.GroupLayout(Reports2);
        Reports2.setLayout(Reports2Layout);
        Reports2Layout.setHorizontalGroup(
            Reports2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Reports2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Reports2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Histogram, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Reports2Layout.createSequentialGroup()
                        .addGap(0, 76, Short.MAX_VALUE)
                        .addComponent(BarChart, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(208, 208, 208))
        );
        Reports2Layout.setVerticalGroup(
            Reports2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Reports2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BarChart, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Histogram, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        Parent.add(Reports2, "card7");

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel14.setText("Account Settings");

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel15.setText("Full name");

        jButton1.setBackground(new java.awt.Color(50, 98, 147));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Save Changes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(50, 98, 147));
        jLabel16.setText("View Recent Logins");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel3.setText("Payment Settings");

        jCheckBox1.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jCheckBox1.setText("Two-Factor Authentication");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel17.setText("Password");

        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(50, 98, 147));
        jLabel18.setText("Change Password");

        jLabel19.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel19.setText("Notification Settings");

        jCheckBox2.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jCheckBox2.setText("Email");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jCheckBox3.setText("SMS");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jCheckBox4.setText("Phone Number");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel20.setText("Theme");

        jRadioButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jRadioButton1.setText("Light");

        jRadioButton2.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jRadioButton2.setText("Dark");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel21.setText("Security Settings");

        jLabel22.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(50, 98, 147));
        jLabel22.setText("Manage Saved Cards");

        jLabel23.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(50, 98, 147));
        jLabel23.setText("Manage Bank Accounts");

        jLabel24.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel24.setText("Privacy Settings ");

        jLabel25.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(50, 98, 147));
        jLabel25.setText("Activity Log");

        jTextField1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jTextField1.setText("Rix Prajapati");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(50, 98, 147));
        jLabel27.setText("Data Sharing");

        Password.setText("jPasswordField1");
        Password.setPreferredSize(new java.awt.Dimension(117, 30));

        showPassword.setText("Show Password");
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SettingLayout = new javax.swing.GroupLayout(Setting);
        Setting.setLayout(SettingLayout);
        SettingLayout.setHorizontalGroup(
            SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SettingLayout.createSequentialGroup()
                        .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SettingLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(SettingLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SettingLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox4)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(SettingLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SettingLayout.createSequentialGroup()
                        .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SettingLayout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SettingLayout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(showPassword)))))
                .addContainerGap(293, Short.MAX_VALUE))
        );
        SettingLayout.setVerticalGroup(
            SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(showPassword)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SettingLayout.createSequentialGroup()
                        .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22))
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel25))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        Parent.add(Setting, "card6");

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainLayout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(Parent, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Parent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(main);
        main.setBounds(0, 0, 1000, 760);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void History_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_History_btnMouseClicked
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(History);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_History_btnMouseClicked

    private void Dashboard_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Dashboard_btnMouseClicked
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(Dashboard);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_Dashboard_btnMouseClicked

    private void Dashboard_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Dashboard_btnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Dashboard_btnMouseEntered

    private void Setting_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Setting_btnMouseClicked
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(Setting);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_Setting_btnMouseClicked

    private void UserList_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserList_btnMouseClicked
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(UserList);
        Parent.repaint();
        Parent.revalidate();
        UserMngmtController controller = new UserMngmtController(this);
        
    }//GEN-LAST:event_UserList_btnMouseClicked

    private void Reports_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Reports_btnMouseClicked
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(Reports);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_Reports_btnMouseClicked

    private void Reports_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Reports_btn1MouseClicked
        // TODO add your handling code here:
        Parent.removeAll();
        Parent.add(Reports2);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_Reports_btn1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void showPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordActionPerformed
        // TODO add your handling code here:
        if(showPassword.isSelected()){
            Password.setEchoChar((char)0);
        }else{
            Password.setEchoChar('*');
        }
    }//GEN-LAST:event_showPasswordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminDashboards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboards.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboards().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarChart;
    private javax.swing.JPanel Currentbalance;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JLabel Dashboard_btn;
    private javax.swing.JPanel DuePayment;
    private javax.swing.JPanel DuePayment1;
    private javax.swing.JPanel DuePayment2;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Histogram;
    private javax.swing.JPanel History;
    private javax.swing.JLabel History_btn;
    private javax.swing.JPanel LineChart;
    private javax.swing.JPanel Parent;
    private javax.swing.JPasswordField Password;
    private javax.swing.JPanel PieChart;
    private javax.swing.JPanel Reports;
    private javax.swing.JPanel Reports2;
    private javax.swing.JLabel Reports_btn;
    private javax.swing.JLabel Reports_btn1;
    private javax.swing.JPanel Setting;
    private javax.swing.JLabel Setting_btn;
    private javax.swing.JPanel UserList;
    private javax.swing.JLabel UserList_btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel main;
    private javax.swing.JCheckBox showPassword;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables

    public void setUserTableData(Object[][] data){
        DefaultTableModel model = (DefaultTableModel) userTable.getModel();
        JTableHeader header = userTable.getTableHeader();
        header.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        header.setBackground(new java.awt.Color(51, 153, 255)); // Blue background
        header.setForeground(java.awt.Color.WHITE);             // White text
        header.setOpaque(true);
        model.setRowCount(0);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < userTable.getColumnCount(); i++) {
            userTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        for(Object[] row : data){
            model.addRow(row);
        }
    }
}
