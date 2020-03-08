package dk.cphbusiness.banking.files;

import dk.cphbusiness.banking.files.fakes.AccountFake;
import static org.jmock.AbstractExpectations.returnValue;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;

public class AccountMockingTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void testAccountTransferWithNumber() {
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
    }

    @Test
    public void testAccountTransferWithObject() {
        final Customer customer = context.mock(Customer.class);
        final Bank bank = context.mock(Bank.class);

        final String targetNumber = "TGT54321";
        Account source = new AccountFake(bank, customer, "SRC54321");
        Account target = new AccountFake(bank, customer, targetNumber);
        context.checking(new Expectations() {
            {
                never(bank).getAccount(targetNumber);
            }
        });

        source.transfer(10000, target);
        assertEquals(-10000, source.getBalance());
        assertEquals(10000, target.getBalance());
    }

    @Test
    public void testGetWithdrawals() {
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
        assertEquals(source.getWithdrawals().get(0).getAmount(), -10000);
    }

    @Test
    public void testGetDeposits() {
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
        assertEquals(target.getDeposits().get(0).getAmount(), 10000);
    }

    @Test
    public void testGetBalance() {
        final Customer customer = context.mock(Customer.class);
        final Bank bank = context.mock(Bank.class);

        final String targetNumber = "TGT54321";
        final long amount = 10000;
        Account source = new AccountFake(bank, customer, "SRC54321");
        Account target = new AccountFake(bank, customer, targetNumber);
        context.checking(new Expectations() {
            {
                oneOf(bank).getAccount(targetNumber);
                will(returnValue(target));
            }
        });

        source.transfer(amount, "TGT54321");
        assertEquals(target.getBalance(), amount);
    }

    @Test
    public void testSetBalance() {
        final Customer customer = context.mock(Customer.class);
        final Bank bank = context.mock(Bank.class);
        final long amount = 10000;
        Account instance = new AccountFake(bank, customer, "SRC54321");

        instance.setBalance(amount);
        assertEquals(instance.getBalance(), amount);
    }
}
