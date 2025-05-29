/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Database.MyDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserData;
/**
 *
 * @author User
 */
public class UserDao {
    MyDatabase mysql=new MyDatabase();
    Connection conn=mysql.openConnection();
    
    public void signUp(UserData user){
        String sql="Insert into users (username,email,password,number) values (?,?,?,?)";
        try(PreparedStatement pstm=conn.prepareStatement(sql)){
          pstm.setString(1, user.getUsername());
          pstm.setString(2, user.getEmail());
          pstm.setString(3, user.getPassword());
          pstm.setString(4, user.getNumber());
          pstm.executeUpdate();
          
        }catch(SQLException ex){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            mysql.closeConnection(conn);
        }
    }
    public boolean checkUser(UserData user) {
        String sql = "SELECT * FROM users WHERE email = ? OR username = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, user.getEmail());
            pstm.setString(2, user.getUsername());
            java.sql.ResultSet result = pstm.executeQuery();
            return result.next();
        } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }
}

