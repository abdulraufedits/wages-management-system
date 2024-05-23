package wagesmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Connector {

    private static final String dLoc = "jdbc:ucanaccess://WMSDB.accdb";
    Connection conn;
    PreparedStatement prep;
    ResultSet rs;

    public Connector() {
        try {
            conn = DriverManager.getConnection(dLoc);
            System.out.println("Connection Successful");
        } catch (SQLException e) {
            System.out.println("Problem While Connecting");
            System.out.println(e.getMessage());

        }

    }

    public ResultSet runSelect(String query) {
        try {
            prep = conn.prepareStatement(query);
            
            rs = prep.executeQuery();// only for select queries
            System.out.println("Query executed successfully");
            return rs;
        } catch (SQLException e) {
            System.out.println("Problem while executing query");
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void validateLogin(String user, String name, String pass,JFrame window,JFrame frame_login){
        if(user.equals("employee")){
            try {
            prep = conn.prepareStatement("SELECT empname, pass from employee WHERE empname= ? AND pass= ?");
            prep.setString(1, name);
            prep.setString(2,pass);
            rs = prep.executeQuery();// only for select queries
            System.out.println("Query executed successfully");
            if(!rs.next()){
                System.out.println("Username or password is incorrect.");
                JOptionPane.showMessageDialog(window, "Username or password is incorrect");
            } else{
                JOptionPane.showMessageDialog(window, "Logged in as " + user +": " + name);
                EmployeeUI empUI = new EmployeeUI(name, pass);
                empUI.pack();
                empUI.setVisible(true);
                window.setVisible(false);
                frame_login.setVisible(false);
            }
        } catch (SQLException e) {
            System.out.println("Problem while executing query");
            System.out.println(e.getMessage());
        }
            
            
        } else if(user.equals("manager")){
            try {
            prep = conn.prepareStatement("SELECT managername, pass from manager WHERE managername=? AND pass=?");
            prep.setString(1, name);
            prep.setString(2,pass);
            rs = prep.executeQuery();// only for select queries
            System.out.println("Query executed successfully");
            if(!rs.next()){
                System.out.println("Username or password is incorrect.");
                JOptionPane.showMessageDialog(window, "Username or password is incorrect");
            } else{
                JOptionPane.showMessageDialog(window, "Logged in as " + user +": " + name);
                ManagerUI mngUI = new ManagerUI(name, pass);
                mngUI.pack();
                mngUI.setVisible(true);
                window.setVisible(false);
                frame_login.setVisible(false);
            }
        } catch (SQLException e) {
            System.out.println("Problem while executing query");
            System.out.println(e.getMessage());
        }
        } else if(user.equals("admin")){
            try {
            prep = conn.prepareStatement("SELECT adminname, pass from admin WHERE adminname=? AND pass=?");
            prep.setString(1, name);
            prep.setString(2,pass);
            rs = prep.executeQuery();// only for select queries
            System.out.println("Query executed successfully");
            if(!rs.next()){
                System.out.println("Username or password is incorrect.");
                JOptionPane.showMessageDialog(window, "Username or password is incorrect");
            } else{
                JOptionPane.showMessageDialog(window, "Logged in as " + user);
                AdminUI adminUI = new AdminUI(name, pass);
                adminUI.pack();
                adminUI.setVisible(true);
                window.setVisible(false);
                frame_login.setVisible(false);
            }
        } catch (SQLException e) {
            System.out.println("Problem while executing query");
            System.out.println(e.getMessage());
        }
        }
    }
    public void runDML(String query) {
        try {
            prep = conn.prepareStatement(query);
            prep.executeUpdate();//for for insert update delete queries
            System.out.println("Record Inserted successfully");
        } catch (SQLException e) {
            System.out.println("Problem while inserting Record");
            System.out.println(e.getMessage());
        }
        
    }
    public void runUpdate(String query,String data_current,String data_new,JPanel panel_name, String data){
        try {
            prep = conn.prepareStatement(query);
            int res = JOptionPane.showConfirmDialog(panel_name, "Are you sure want to change your "+ data+ "?");
            if(res == 0){
                prep.setString(1,data_new);//for for insert update delete queries
            prep.executeUpdate();
            System.out.println("Record updated successfully");
            
            } else {
                System.out.println("No action taken.");
            }
        } catch (SQLException e) {
            System.out.println("Problem while inserting Record");
            System.out.println(e.getMessage());
        }
    }
    public void runDelAcc(String query, JFrame window, JPanel panel_name){
        int res = JOptionPane.showConfirmDialog(panel_name, "Are you sure want to delete your account?");
        if(res == 0){
           runDML(query);
        System.out.println("Deleted successfully");
            new MainMenu().setVisible(true);
            window.setVisible(false);
        
        } else {
            System.out.println("No action taken.");
        }
    }
}
