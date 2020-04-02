package DataLayer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.teamwingitt.banking.contractTest.IAccountManagerTest;
import com.teamwingitt.banking.contractTest.ICustomerManagerTest;
import com.teamwingitt.banking.contractTest.IBankManagerTest;
import com.teamwingitt.banking.contractTest.ManagerHolder;
import implementations.db.AccountManager;
import implementations.db.BankManager;
import implementations.db.CustomerManager;
import java.io.IOException;
import java.sql.SQLException;
import org.junit.AfterClass;
import org.junit.BeforeClass;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    DBConnectorTest.class,
    IAccountManagerTest.class,
    ICustomerManagerTest.class,
    IBankManagerTest.class
})

public class ContractManagerDBTest {

    @BeforeClass
    public static void before() throws IOException {

        Utils.establishDBConnection();
        Utils.runSQLScript("banking_create_test_db.sql");
        Utils.runSQLScript("bank_test_setup.sql");
        Utils.runSQLScript("account_test_setup.sql");
        Utils.runSQLScript("customer_test_setup.sql");
        Utils.runSQLScript("movement_test_setup.sql");
        ManagerHolder.accountManager = new AccountManager();
        ManagerHolder.bankManager = new BankManager();
        ManagerHolder.customerManager = new CustomerManager();
    }
    
    @AfterClass
    public static void after() throws SQLException {
        DBConnector.getConnection().close();
    }

}
