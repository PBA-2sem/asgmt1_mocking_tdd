package api;

import DTOs.AccountDetails;
import DTOs.BankDetails;
import DTOs.CustomerDetails;
import DTOs.MovementDetails;
import DataLayer.DBConnector;
import DataLayer.Utils;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.Response;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
@Category(Integration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApiResourceTest {

    Gson gson = new Gson();
    ApiResource instance = new ApiResource();

    @BeforeClass
    public static void before() throws IOException {
        Utils.establishDBConnection();
        Utils.runSQLScript("banking_create_test_db.sql");
        Utils.runSQLScript("bank_test_setup.sql");
        Utils.runSQLScript("account_test_setup.sql");
        Utils.runSQLScript("customer_test_setup.sql");
        Utils.runSQLScript("movement_test_setup.sql");
    }

    @AfterClass
    public static void after() throws SQLException {
        DBConnector.getConnection().close();
    }

    // CUSTOMER TESTS
    /**
     * Test of getCustomer method, of class ApiResource. Test that customer with
     * id 1 has the name Jeff
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAGetCustomer() throws Exception {
        System.out.println("getCustomer");
        String id = "1";
        String expName = "Jeff";
        CustomerDetails result = gson.fromJson(instance.getCustomer(id), CustomerDetails.class);
        assertEquals(expName, result.getName());
    }

    /**
     * Test of getAccounts method, of class ApiResource. Test that customer with
     * id 1 has 2 accounts and that the customer name of those accounts are Jeff
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAGetAccounts() throws Exception {
        System.out.println("getAccounts");
        String id = "1";
        String expName = "Jeff";
        int expNumberOfAccounts = 2;
        AccountDetails[] resultJson = gson.fromJson(instance.getAccounts(id), AccountDetails[].class);
        List<AccountDetails> ListOfAccounts = Arrays.asList(resultJson);
        ListOfAccounts.forEach((account) -> {
            assertEquals(account.getCustomer(), expName);
        });
        assertEquals(ListOfAccounts.size(), expNumberOfAccounts);

    }

    //BANK TESTS
    /**
     * Test of getBank method, of class ApiResource. Test that bank with id 1
     * has the name Danske Bank
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAGetBank() throws Exception {
        System.out.println("getBank");
        String id = "1";
        String expResult = "Danske Bank";
        BankDetails result = gson.fromJson(instance.getBank(id), BankDetails.class);
        assertEquals(expResult, result.getName());
    }

    /**
     * Test of getBankAccounts method, of class ApiResource. Test that bank with
     * id 1 has two accounts and that the name of the bank is Danske Bank
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAGetBankAccounts() throws Exception {
        System.out.println("getBankAccounts");
        String id = "1";
        int expNumberOfAccounts = 2;
        String expName = "Danske Bank";
        AccountDetails[] resultJson = gson.fromJson(instance.getBankAccounts(id), AccountDetails[].class);
        List<AccountDetails> ListOfAccounts = Arrays.asList(resultJson);
        ListOfAccounts.forEach((account) -> {
            assertEquals(account.getBank(), expName);
        });
        assertEquals(ListOfAccounts.size(), expNumberOfAccounts);
    }

    // ACCOUNT TESTS 
    /**
     * Test of getAccount method, of class ApiResource. Test that account with
     * id 1 has the bank name Danske Bank, the customer name Jeff, the number 1,
     * balance 0, number of withdrawals 3, number of deposits 3.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAGetAccount() throws Exception {
        System.out.println("getAccount");
        String id = "1";
        String expBankName = "Danske Bank";
        String expCustomerName = "Jeff";
        String expNumber = "1";
        long expBalance = 20;
        int expNumberOfWithdrawals = 0;
        int expNumberOfDeposits = 1;
        AccountDetails result = gson.fromJson(instance.getAccount(id), AccountDetails.class);
        assertEquals(result.getBank(), expBankName);
        assertEquals(result.getCustomer(), expCustomerName);
        assertEquals(result.getNumber(), expNumber);
        assertEquals(result.getBalance(), expBalance);
        assertEquals(result.getWithdrawals().size(), expNumberOfWithdrawals);
        assertEquals(result.getDeposits().size(), expNumberOfDeposits);
    }

    /**
     * Test of getBalance method, of class ApiResource. Test that account with
     * id 1 has the balance of 0
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAGetBalance() throws Exception {
        System.out.println("getBalance");
        String id = "1";
        long expBalance = 20;
        long result = gson.fromJson(instance.getBalance(id), long.class);
        assertEquals(expBalance, result);
    }

    /**
     * Test of getWithdrawals method, of class ApiResource. Test that account
     * with id 1 has list of withdrawals of the size 3
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAGetWithdrawals() throws Exception {
        System.out.println("getWithdrawals");
        String id = "1";
        int expNumberOfWithdrawals = 0;
        MovementDetails[] resultJson = gson.fromJson(instance.getWithdrawals(id), MovementDetails[].class);
        List<MovementDetails> ListOfWithdrawals = Arrays.asList(resultJson);
        assertEquals(expNumberOfWithdrawals, ListOfWithdrawals.size());
    }

    /**
     * Test of getDeposits method, of class ApiResource. Test that account with
     * id 1 has list of deposits of the size 4
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testAGetDeposits() throws Exception {
        System.out.println("getDeposits");
        String id = "1";
        int expNumberOfDeposits = 1;
        MovementDetails[] resultJson = gson.fromJson(instance.getDeposits(id), MovementDetails[].class);
        List<MovementDetails> ListOfDeposits = Arrays.asList(resultJson);
        assertEquals(expNumberOfDeposits, ListOfDeposits.size());
    }

    /**
     * Test of transferByAccountIdentifier method, of class ApiResource. Test
     * that the transfer of amount 40 from source 2 to target 1 results on a
     * Response with code 200
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testATransferByAccountIdentifier() throws Exception {
        System.out.println("transferByAccountIdentifier");
        String amount = "40";
        String source = "2";
        String target = "1";
        int expStatus = 200;
        Response resultResponse = instance.transferByAccountIdentifier(amount, source, target);
        assertEquals(expStatus, resultResponse.getStatus());
    }

    /**
     * Test of transferByAccountNumber method, of class ApiResource. Test that
     * the transfer of amount 40 from sourceAccNumber 1 to targetAccNumber 2
     * results on a Response with code 200
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testATransferByAccountNumber() throws Exception {
        System.out.println("transferByAccountNumber");
        String amount = "40";
        String sourceAccNumber = "1";
        String targetAccNumber = "2";
        int expStatus = 200;
        Response resultResponse = instance.transferByAccountNumber(amount, sourceAccNumber, targetAccNumber);
        assertEquals(expStatus, resultResponse.getStatus());
    }

    /**
     * Test of deposit method, of class ApiResource. Test that the deposit of
     * amount 100 to id 1 results in a Response with code 200
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testBDeposit() throws Exception {
        System.out.println("deposit");
        String amount = "100";
        String id = "1";
        int expStatus = 200;
        Response resultResponse = instance.deposit(amount, id);
        assertEquals(expStatus, resultResponse.getStatus());
    }

    /**
     * Test of withdraw method, of class ApiResource. Test that the withdraw of
     * amount 100 from id 1 results in a Response with code 200
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testBWithdraw() throws Exception {
        System.out.println("withdraw");
        String amount = "100";
        String id = "1";
        int expStatus = 200;
        Response resultResponse = instance.withdraw(amount, id);
        assertEquals(expStatus, resultResponse.getStatus());
    }

}
