/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package powerpay;
import Database.*;
/**
 *
 * @author User
 */
public class PowerPay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Database db=new Database();
        if (db.openConnection() == null) {
            System.out.println("Failed to connect to database.");
        } else {
            System.out.println("Database connected successfully!");
        }
    }
    
}
