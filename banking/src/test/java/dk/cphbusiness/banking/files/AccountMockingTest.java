package dk.cphbusiness.banking.files;

import dk.cphbusiness.banking.files.fakes.AccountFake;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountMockingTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void testAccountTransfer() {
        final Customer customer = context.mock(Customer.class);
        final Bank bank = context.mock(Bank.class);
        
        final String targetNumber = "TGT54321";
        Account source = new AccountFake(bank, customer, "SRC54321");
        Account target = new AccountFake(bank, customer, targetNumber);
        context.checking(new Expectations() {
            {
                oneOf(bank).getAccount(targetNumber);
                will(returnValue(target));
            }
        });

        source.transfer(10000, "TGT54321");
        assertEquals(-10000, source.getBalance());
        assertEquals(10000, target.getBalance());
        
        assertEquals(source.getWithdrawals().get(0).getAmount(), -10000);
        assertEquals(target.getDeposits().get(0).getAmount(), 10000);
        
        

    }

}
