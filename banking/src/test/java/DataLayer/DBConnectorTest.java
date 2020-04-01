/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.ibatis.jdbc.ScriptRunner;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class DBConnectorTest {

    DBConnector dbconnector;

    public DBConnectorTest() {

        dbconnector = new DBConnector();
    }

    @BeforeClass
    public static void setUpClass() {

        String DRIVER = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://207.154.222.88:3306/bankingTest";
        String USER = "bank_tester"; // test user
        String PASSWORD = "passw0rd";
        Connection conn = null;

        try {
            if (conn == null || conn.isClosed()) {
                Class.forName(DRIVER).newInstance();
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                DBConnector.setConn(conn);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            System.out.println("ERROR 42");
        }

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FileNotFoundException, IOException {
        Utils.runSQLScript(dbconnector, "banking_create_test_db.sql");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setConn method, of class DBConnector.
     */
    @Test
    public void testSetAndGetConnection() throws SQLException {
        System.out.println("setAndGetConnection");
        Connection conn = dbconnector.getConnection();
        assertFalse(conn.isClosed());
    }

}
