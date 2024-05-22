package wagesmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
