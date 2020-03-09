/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.banking.tests;

import dk.cphbusiness.banking.interfaces.Account;
import dk.cphbusiness.banking.interfaces.Bank;
import dk.cphbusiness.banking.interfaces.Customer;
import exceptions.NotFoundException;
import implementations.AccountImpl;
import org.jmock.integration.junit4.JUnitRuleMockery;
import implementations.CustomerImpl;
import org.jmock.Expectations;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author Andreas
 */
public class CustomerTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test(expected = NotFoundException.class)
    public void testCustomerTransferNotFoundException() throws NotFoundException {
        System.out.println("testCustomerTransferNotFoundException");
        final Bank bank = context.mock(Bank.class);

        final String cName = "Andreas";
        final String cCpr = "123456789";

        Customer c = new CustomerImpl(cCpr, cName, bank);

        Account source = new AccountImpl(bank, c, "SRC54321");

        c.transfer(10000, source, null);

    }

    @Test
    public void testCustomerTransfer() throws NotFoundException {
        System.out.println("testCustomerTransfer");
        final Bank bank = context.mock(Bank.class);

        final String cName = "Andreas";
        final String cCpr = "123456789";

        Customer c = new CustomerImpl(cCpr, cName, bank);

        final String targetNumber = "TGT54321";
        Account source = new AccountImpl(bank, c, "SRC54321");
        Account target = new AccountImpl(bank, c, targetNumber);

        c.transfer(10000, source, target);

        assertEquals(-10000, source.getBalance());
        assertEquals(10000, target.getBalance());

    }

    @Test(expected = NotFoundException.class)
    public void testGetListOfWithdrawalNotFoundException() throws NotFoundException {
        System.out.println("testGetListOfWithdrawalNotFoundException");
        final Bank bank = context.mock(Bank.class);

        final String cName = "Andreas";
        final String cCpr = "123456789";
        final String accNo = "1";

        Customer c = new CustomerImpl(cCpr, cName, bank);

        c.getListOfWithdrawal(accNo);
    }

    @Test
    public void testGetListOfWithdrawal() throws NotFoundException {
        System.out.println("testGetListOfWithdrawal");
        final Bank bank = context.mock(Bank.class);

        final String cName = "Andreas";
        final String cCpr = "123456789";
        final String accNo = "1";
        final int expected = 2;

        Customer c = new CustomerImpl(cCpr, cName, bank);
        Account acc = new AccountImpl(bank, c, accNo);

        acc.withdraw(100);
        acc.withdraw(100);
        c.addAccount(acc);

        assertEquals(c.getListOfWithdrawal(accNo).size(), expected);
    }

    @Test(expected = NotFoundException.class)
    public void testGetListOfDepositNotFoundException() throws NotFoundException {
        System.out.println("testGetListOfDepositNotFoundException");
        final Bank bank = context.mock(Bank.class);

        final String cName = "Andreas";
        final String cCpr = "123456789";
        final String accNo = "1";

        Customer c = new CustomerImpl(cCpr, cName, bank);

        c.getListOfDeposits(accNo);
    }

    @Test
    public void testGetListOfDeposit() throws NotFoundException {
        System.out.println("testGetListOfDeposit");
        final Bank bank = context.mock(Bank.class);

        final String cName = "Andreas";
        final String cCpr = "123456789";
        final String accNo = "1";
        final int expected = 2;

        Customer c = new CustomerImpl(cCpr, cName, bank);
        Account acc = new AccountImpl(bank, c, accNo);

        acc.deposit(100);
        acc.deposit(100);
        c.addAccount(acc);

        assertEquals(c.getListOfDeposits(accNo).size(), expected);
    }

    @Test
    public void testAddAccount() {
        System.out.println("testAddAccount");
        final Bank bank = context.mock(Bank.class);

        final String accNo = "1";
        final Account account = context.mock(Account.class);

        final String cName = "Andreas";
        final String cCpr = "123456789";

        Customer c = new CustomerImpl(cCpr, cName, bank);

        context.checking(new Expectations() {
            {

                oneOf(account).getNumber();
                will(returnValue(accNo));
            }
        });
        c.addAccount(account);
        assertEquals(c.getAccounts().size(), 1);
    }

}
