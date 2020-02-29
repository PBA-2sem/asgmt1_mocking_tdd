package dk.cphbusiness.banking.files;

import dk.cphbusiness.banking.files.AccountTest.AccountImpl;
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
        Account source = new AccountImpl(bank, customer, "SRC54321");
        Account target = new AccountImpl(bank, customer, targetNumber);
        context.checking(new Expectations() {
            {
                oneOf(bank).getAccount(targetNumber);
                will(returnValue(target));
                //oneOf(bank).getName();
            }
        });

        source.transfer(10000, "TGT54321");
        assertEquals(-10000, source.getBalance());
        assertEquals(10000, target.getBalance());

        //context.assertIsSatisfied();
    }

}
