package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://207.154.222.88:3306/banking"; //"jdbc:mysql://207.154.222.88:3306/fog";
    private static final String USER = "bank_prod";
    private static final String PASSWORD = "passw0rd";
    private static Connection conn = null;

    public static void setConn(Connection conn) {
        DBConnector.conn = conn;
    }

    public static Connection getConnection()  {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName(DRIVER).newInstance();
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            System.out.println("ERROR 42");
        }
        return conn;
    }

    /* USED AFTER A MAPPER METHEOD IS EXECUTED TO CLOSE STANDING CONNECTIONS !!!
    try {
    
    //// MAPPER METHEOD HERE 
    
    finally
    {
        // Always make sure result sets and statements are closed,
        // and the connection is returned to the pool
        
            if (rs != null)
                rs.close ();
            if (stmt != null)
                stmt.close ();
            if (pstmt != null)
                pstmt.close ();
            if (conn != null)
                conn.close ();
        }
        */
}