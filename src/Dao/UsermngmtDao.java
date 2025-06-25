/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Database.MyDatabase;
import model.UserMngmt;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JButton;
/**
 *
 * @author Ishan
 */
public class UsermngmtDao {
    MyDatabase mysql = new MyDatabase();

    public List<UserMngmt> getAllusers(){
        List<UserMngmt> users = new ArrayList<>();
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users";
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                UserMngmt u = new UserMngmt(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getDate("created_at"),
                    rs.getString("phone_number"),
                    new JButton("Add Bill")    
                );
                users.add(u);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return users;
    }
}