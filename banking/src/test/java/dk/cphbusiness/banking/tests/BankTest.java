package dk.cphbusiness.banking.tests;

import dk.cphbusiness.banking.interfaces.Account;
import dk.cphbusiness.banking.interfaces.Bank;
import dk.cphbusiness.banking.interfaces.Customer;
import implementations.AccountImpl;
import implementations.BankImpl;
import implementations.CustomerImpl;
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

        final String targetNumber = "TGT54321";
        final String cvr = "23456789";
        final String name = "BankBank";
        final Bank bank = new BankImpl(cvr, name, new HashMap<>());

        final Account acc = new AccountImpl(bank, customer, targetNumber);

        context.checking(new Expectations() {
            {
                oneOf(customer).addAccount(acc);
            }
        });

        bank.addAccount(acc);
        Account accountRes = bank.getAccount(targetNumber);
        assertEquals(acc, accountRes);
    }

    @Test
    public void testGetAccounts() {
        final String cvr = "23456789";
        final String name = "BankBank";
        final Bank bank = new BankImpl(cvr, name, new HashMap<>());

        final String cpr = "23456768";
        final String cName = "jeff";
        final Customer customer = new CustomerImpl(cpr, cName, bank);

        final String accNumber = "1";
        final String accNumberSecond = "2";

        bank.addAccount(new AccountImpl(bank, customer, accNumber));
        bank.addAccount(new AccountImpl(bank, customer, accNumberSecond));

        assertEquals(customer.getAccounts().size(), 2);
    }

}
