/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Dao.UsermngmtDao;
import model.UserMngmt;
import java.util.List;
import View.AdminDashboards;

/**
 *
 * @author anish
 */
public final class UserMngmtController {
    private final UsermngmtDao userDao;
    private AdminDashboards view;
    
    public UserMngmtController(AdminDashboards view){
    this.userDao = new UsermngmtDao();
    this.view = view;
    loadUsersTotable();
    }
    
    public void open(){
        this.view.setVisible(true);
    }
    
    public void close(){
        this.view.dispose();
    }
    
    public void loadUsersTotable(){
        List<UserMngmt> users = userDao.getAllusers();
        
        Object[][] data = new Object[users.size()][8];
        
        for(int i =0; i<users.size() ; i++){
            UserMngmt u = users.get(i);
            data[i][0]=i+1;
            data[i][1]=u.getUsername();
            data[i][2]=u.getEmail();
            data[i][3]=u.getCreated_at();
        }
        
        view.setUserTableData(data);
        
    }
    
    
}