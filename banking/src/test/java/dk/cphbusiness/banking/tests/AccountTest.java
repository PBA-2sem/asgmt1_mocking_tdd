package dk.cphbusiness.banking.tests;

import dk.cphbusiness.banking.interfaces.Account;
import dk.cphbusiness.banking.interfaces.Bank;
import dk.cphbusiness.banking.interfaces.Customer;
import exceptions.NotFoundException;
import implementations.AccountImpl;
import java.util.ArrayList;
import static org.jmock.AbstractExpectations.returnValue;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;

public class AccountTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void testGetBank() {
        final Customer customer = context.mock(Customer.class);
        final Bank bank = context.mock(Bank.class);
        final Account accMock = context.mock(Account.class);
        context.checking(new Expectations() {
            {

                oneOf(accMock).getBank();
                will(returnValue(bank));
            }
        });
        assertEquals(accMock.getBank(), bank);
    }

    @Test
    public void testAccountTransferWithNumber() throws NotFoundException {
        System.out.println("testAccountTransferWithNumber");
        final Customer customer = context.mock(Customer.class);
        final Bank bank = context.mock(Bank.class);

        final String targetNumber = "TGT54321";
        final long amount = 10000;

        Account source = new AccountImpl(bank, customer, "SRC54321");
        Account target = new AccountImpl(bank, customer, targetNumber);
        context.checking(new Expectations() {
            {
                oneOf(bank).getAccount(targetNumber);
                will(returnValue(target));
            }
        });

        source.transfer(amount, "TGT54321");
        assertEquals(-amount, source.getBalance());
        assertEquals(amount, target.getBalance());
    }

    @Test
    public void testAccountTransferWithObject() throws NotFoundException {
        System.out.println("testAccountTransferWithObject");
        final Customer customer = context.mock(Customer.class);
        final Bank bank = context.mock(Bank.class);

        final String targetNumber = "TGT54321";
        Account source = new AccountImpl(bank, customer, "SRC54321");
        Account target = new AccountImpl(bank, customer, targetNumber);
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
        System.out.println("testGetWithdrawals");
        final Customer customer = context.mock(Customer.class);
        final Bank bank = context.mock(Bank.class);

        Account instance = new AccountImpl(bank, customer, "SRC54321");

        assertEquals(instance.getDeposits().getClass(), ArrayList.class);
    }

    @Test
    public void testGetDeposits() {
        System.out.println("testGetDeposits");
        final Customer customer = context.mock(Customer.class);
        final Bank bank = context.mock(Bank.class);

        Account instance = new AccountImpl(bank, customer, "SRC54321");

        assertEquals(instance.getWithdrawals().getClass(), ArrayList.class);
    }

    @Test
    public void testGetBalance() {
        System.out.println("testGetBalance");
        final Customer customer = context.mock(Customer.class);
        final Bank bank = context.mock(Bank.class);

        Account instance = new AccountImpl(bank, customer, "SRC54321");

        assertEquals(instance.getBalance(), 0);
    }

    @Test
    public void testDeposit() {
        System.out.println("testDeposit");
        final Customer customer = context.mock(Customer.class);
        final Bank bank = context.mock(Bank.class);

        final long amount = 10000;
        Account instance = new AccountImpl(bank, customer, "SRC54321");

        instance.deposit(amount);
        assertEquals(instance.getBalance(), amount);
        assertTrue(instance.getDeposits().size() == 1);
    }

    @Test
    public void testWithdraw() {
        System.out.println("testWithdraw");
        final Customer customer = context.mock(Customer.class);
        final Bank bank = context.mock(Bank.class);

        final long amount = 10000;
        Account instance = new AccountImpl(bank, customer, "SRC54321");

        instance.withdraw(amount);
        assertEquals(instance.getBalance(), -amount);
        assertTrue(instance.getWithdrawals().size() == 1);
    }
}
