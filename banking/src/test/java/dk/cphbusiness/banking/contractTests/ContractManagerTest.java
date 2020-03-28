package dk.cphbusiness.banking.contractTests;

import com.teamwingitt.banking.contract.IBankManager;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.teamwingitt.banking.contractTest.IAccountManagerTest;
import com.teamwingitt.banking.contractTest.ICustomerManagerTest;
import com.teamwingitt.banking.contractTest.IBankManagerTest;
import com.teamwingitt.banking.contractTest.ManagerHolder;
import org.junit.BeforeClass;

@RunWith (Suite.class)
@Suite.SuiteClasses({IAccountManagerTest.class, ICustomerManagerTest.class, IBankManagerTest.class})

public class ContractManagerTest {
 
    @BeforeClass
    public static void beforeClass() {
        ManagerHolder.accountManager = new AccountManagerDummy();
        ManagerHolder.bankManager = new BankManagerDummy();
        ManagerHolder.customerManager = new CustomerManagerDummy();
    }
    
}
