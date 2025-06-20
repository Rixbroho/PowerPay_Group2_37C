/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Database.MyDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.LoginRequest;
import model.UserData;
/**
 *
 * @author User
 */
public class UserDao {
    MyDatabase mysql=new MyDatabase();
    
    public void Createsignup(UserData user){
        Connection conn=mysql.openConnection();
        String sql="INSERT INTO users (username, email, password, phone_number, keep_logged_in) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement pstm=conn.prepareStatement(sql)){
          pstm.setString(1, user.getUsername());
          pstm.setString(2, user.getEmail());
          pstm.setString(3, user.getPassword());
          pstm.setString(4, user.getNumber());
          pstm.setBoolean(5, user.getKeepLoggedIn());
          
          pstm.executeUpdate();
          
        }catch(SQLException ex){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,ex);
        } finally {
            mysql.closeConnection(conn);
        }
    }
    
    public boolean checkUser(UserData user) {
        Connection conn=mysql.openConnection();
        String sql = "SELECT * FROM users WHERE email = ? and password = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, user.getEmail());
            pstm.setString(2, user.getPassword());
            ResultSet result = pstm.executeQuery();
            return result.next();
        } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }
    
    public UserData login(LoginRequest login){
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users where email = ? and password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, login.getEmail());
            pstmt.setString(2, login.getPassword());
            ResultSet result = pstmt.executeQuery();
            if(result.next()){
                UserData user  = new UserData(
                    result.getString("email"),
                    result.getString("username"),
                    result.getString("password"),
                    result.getString("phone_number"),
                    result.getBoolean("keep_logged_in")
                );
                user.setId(result.getInt("id"));
                
                return user;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return null;
    }
    
    public UserData loginAdmin(LoginRequest login){
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM admin where email = ? and password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, login.getEmail());
            pstmt.setString(2, login.getPassword());
            ResultSet result = pstmt.executeQuery();
            if(result.next()){
                UserData user  = new UserData(
                    result.getString("email"),
                    result.getString("username"),
                    result.getString("password"),
                    result.getString("phone_number"),
                    result.getBoolean("keep_logged_in")
                );
                user.setId(result.getInt("id"));
                
                return user;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return null;
    }
    
    public boolean checkMail(String email) {
        Connection conn=mysql.openConnection();
        String sql = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, email);
            ResultSet result = pstm.executeQuery();
            return result.next();
        } catch (SQLException ex) {
        Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }
    
    public boolean updatePassword(String email, String newPassword) {
        String sql = "UPDATE users SET password = ? WHERE email = ?";
        Connection conn = mysql.openConnection();

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newPassword);
            pstmt.setString(2, email);

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}

