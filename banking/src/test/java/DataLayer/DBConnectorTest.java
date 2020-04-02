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
}
