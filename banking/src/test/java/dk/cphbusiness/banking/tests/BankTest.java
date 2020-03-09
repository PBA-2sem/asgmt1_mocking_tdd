package dk.cphbusiness.banking.tests;

import dk.cphbusiness.banking.interfaces.Account;
import dk.cphbusiness.banking.interfaces.Bank;
import dk.cphbusiness.banking.interfaces.Customer;
import implementations.AccountImpl;
import java.util.HashMap;
import java.util.Map;
import static org.jmock.AbstractExpectations.returnValue;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;

public class BankTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

@Test
    public void testGetAccount() {
        final Customer customer = context.mock(Customer.class);
        final Bank bank = context.mock(Bank.class);
        Account account = new AccountImpl(bank, customer, "SRC54321");
        final String targetNumber = "TGT54321";
        context.checking(new Expectations() {
            {
                oneOf(bank).getAccount(targetNumber);
                will(returnValue(account));
            }
        });
        Account accountRes = bank.getAccount(targetNumber);
        assertEquals(account.getNumber(), accountRes.getNumber());
    }

    @Test
    public void testGetAccounts() {

        final Customer customer = context.mock(Customer.class);
        final Bank bank = context.mock(Bank.class);
        final Map<String, Account> AccountList = new HashMap<>();
        context.checking(new Expectations() {
            {
                oneOf(bank).getAccounts(customer);
                will(returnValue(AccountList));
            }
        });
        Map<String, Account> accountRes = bank.getAccounts(customer);
        assertEquals(AccountList.size(), accountRes.size());

    }

}
