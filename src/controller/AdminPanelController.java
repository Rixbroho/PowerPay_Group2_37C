/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import View.Admindashboard;
import View.Dashboard;
import View.Settings;
import View.Transcations;
import View.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Acer
 */
public class AdminPanelController {
    private Admindashboard dashboard;
    private Settings settings;
    private Transcations transcations;
    private User user;
    
    public AdminPanelController(Admindashboard dashboard){
        this.dashboard = dashboard;
        
        dashboard.addSettingListener(new SettingListener());
        dashboard.addTranscationListener(new TranscationListener());
        dashboard.addUserListener(new UserListener());
        
}
    public AdminPanelController(Settings settings){
        this.settings = settings;
        settings.addDashboardListener(new DashboardListener());
        settings.addTranscationListener(new TranscationListener());
        settings.addUserListener(new UserListener());
    }
    
    public AdminPanelController(Transcations transcations){
        this.transcations = transcations;
        transcations.addSettingListener(new SettingListener());
        transcations.addDashboardListener(new DashboardListener());
        transcations.addUserListener(new UserListener());
    }
    
    public AdminPanelController(User user){
        this.user = user;
        user.addSettingListener(new SettingListener());
        user.addDashboardListener(new DashboardListener());
        user.addTranscationListener(new TranscationListener());
    }
    
     public void opend() {
        this.dashboard.setVisible(true);
    }
    public void closed() {
        this.dashboard.dispose();
    }
     public void opens() {
        this.settings.setVisible(true);
    }
    public void closes() {
        this.settings.dispose();
    }
     public void opent() {
        this.transcations.setVisible(true);
    }
    public void closet() {
        this.transcations.dispose();
    }
     public void openu() {
        this.user.setVisible(true);
    }
    public void closeu() {
        this.user.dispose();
    }
    
    class SettingListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Settings setting = new Settings();
            AdminPanelController controller =new AdminPanelController(settings);
            controller.opens();
        }
        
    }
    class DashboardListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Admindashboard dashboard = new Admindashboard();
            AdminPanelController controller =new AdminPanelController(dashboard);
            controller.opend();
        }
        
    }
    
    class UserListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            User user = new User();
            AdminPanelController controller =new AdminPanelController(user);
            controller.openu();
        }
        
    }
    
    class TranscationListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Transcations transcations = new Transcations();
            AdminPanelController controller =new AdminPanelController(transcations);
            controller.opent();
        }
        
    }
}
