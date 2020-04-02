/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementations.db;

import DTOs.AccountDetails;
import DTOs.BankDetails;
import DTOs.identifiers.BankIdentifier;
import DTOs.identifiers.CustomerIdentifier;
import DataLayer.DBConnector;
import DataLayer.Utils;
import dao.AccountDAO;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class BankManagerTest {

    static DBConnector dbconnector;
    AccountDAO accDao;

    public BankManagerTest() {

        dbconnector = new DBConnector();
        accDao = new AccountDAO(dbconnector);
    }

    @BeforeClass
    public static void setUpClass() throws IOException {
        Utils.establishDBConnection();
        Utils.runSQLScript("banking_create_test_db.sql");
        Utils.runSQLScript("bank_test_setup.sql");
    }

    /**
     * Test of getBank method, of class BankManager.
     */
    @Test
    public void testGetBank() throws Exception {
        System.out.println("getBank");

        BankIdentifier id = new BankIdentifier("1");
        BankManager instance = new BankManager();
        String expResult = "1";
        BankDetails result = instance.getBank(id);
        assertEquals(expResult, result.getCvr());
    }

    /**
     * Test of getAccounts method, of class BankManager.
     */
//    @Test
    public void testGetAccounts() throws Exception {
        System.out.println("getAccounts");
        CustomerIdentifier id = null;
        BankManager instance = new BankManager();
        List<AccountDetails> expResult = null;
        List<AccountDetails> result = instance.getAccounts(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}
