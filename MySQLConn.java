package in.trillit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQLConn {
    public Statement initConnection() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:sharemarket.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement(); 
        } catch (Exception ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            ex.printStackTrace();
            System.exit(0);
        }
        return stmt;
    }
    
}
