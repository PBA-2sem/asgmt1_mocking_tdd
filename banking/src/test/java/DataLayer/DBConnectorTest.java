/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import DTOs.AccountDetails;
import dao.AccountDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class DBConnectorTest {

    static DBConnector dbconnector;
    AccountDAO accDao;

    public DBConnectorTest() {

        dbconnector = new DBConnector();
        accDao = new AccountDAO(dbconnector);
    }

    @BeforeClass
    public static void setUpClass() throws IOException {
        Utils.establishDBConnection();
        Utils.runSQLScript("banking_create_test_db.sql");
    }

    /**
     * Test of setConn method, of class DBConnector.
     *
     * @throws java.sql.SQLException
     */
    @Test
    public void testSetAndGetConnection() throws SQLException {
        System.out.println("setAndGetConnection");
        Connection conn = DBConnector.getConnection();
        assertFalse(conn.isClosed());
    }

//    @Test
//    public void testReadAllAccountsFromDB() throws SQLException {
//        System.out.println("readAllAccountsFromDB");
//        
//        List<AccountDetails> result = accDao.readAll();
//        
//        assertTrue(result.get(0) instanceof AccountDetails);
//        assertEquals(result.get(0).getNumber(), "1");
//        assertEquals(result.get(1).getNumber(), "2");
//        assertEquals(result.size(), 2);
//    }
}
