package com.teamwingitt.banking.contractTest;

import DTOs.AccountDetails;
import DTOs.MovementDetails;
import DTOs.identifiers.AccountIdentifier;
import com.teamwingitt.banking.contract.IAccountManager;
import exceptions.NotFoundException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IAccountManagerTest {

    IAccountManager manager;

    public IAccountManagerTest() {
        manager = ManagerHolder.accountManager;
    }

    /**
     * Test of getAccount method, of class IAccountManager.
     */
    @Test
    public void testGetAccount() throws Exception {

        System.out.println("getAccount");
        AccountIdentifier id = new AccountIdentifier("1");

        String expectedName = "DanskeBank";
        String expectedCustomerName = "Stanislav";

        AccountDetails result = manager.getAccount(id);

        assertNotNull(result);
        assertEquals(result.getClass(), AccountDetails.class);
        assertEquals(expectedName, result.getBank());
        assertEquals(expectedCustomerName, result.getCustomer());
    }

    /**
     * Test of transfer method, of class IAccountManager.
     */
    @Test
    public void testTransferWithAccount() throws Exception {
        System.out.println("transferWithAccount");
        AccountIdentifier donald = new AccountIdentifier("7");
        AccountIdentifier erdogan = new AccountIdentifier("8");
        long amount = 100L;
        long expectedBalanaceForDonald = 0;
        long expectedBalanaceForErdogan = 200;
        String sourceAccNumber = "1122"; //dumbledore
        String targetAccNumber = "2211"; //voldemort
        manager.transfer(amount, sourceAccNumber, targetAccNumber);
        assertEquals(expectedBalanaceForDonald, manager.getBalance(donald));
        assertEquals(expectedBalanaceForErdogan, manager.getBalance(erdogan));
    }

    /**
     * Test of transfer method, of class IAccountManager.
     */
    @Test
    public void testTransferWithAccountNumber() throws Exception {
        System.out.println("transferWithAccountNumber");
        AccountIdentifier donald = new AccountIdentifier("5");
        AccountIdentifier erdogan = new AccountIdentifier("6");
        long amount = 10L;
        long expectedBalanaceForDonald = 0;
        long expectedBalanaceForErdogan = 20;
        String sourceAccNumber = "3000"; //donaldtrump
        String targetAccNumber = "4000"; //erdogan
        manager.transfer(amount, sourceAccNumber, targetAccNumber);
        assertEquals(expectedBalanaceForDonald, manager.getBalance(donald));
        assertEquals(expectedBalanaceForErdogan, manager.getBalance(erdogan));
    }

    /**
     * Test of getBalance method, of class IAccountManager.
     */
    @Test
    public void testGetBalance() {
        System.out.println("deposit");
        AccountIdentifier id = new AccountIdentifier("4");
        long expectedBalance = 1000000;
        assertEquals(expectedBalance, manager.getBalance(id));
    }

    /**
     * Test of getWithdrawals method, of class IAccountManager.
     */
    @Test
    public void testGetWithdrawals() {
        System.out.println("getWithdrawals");
        AccountIdentifier id = new AccountIdentifier("2");
        int expectedNumberOfWidthdrawals = 2;
        List<MovementDetails> result = manager.getWithdrawals(id);
        assertEquals(expectedNumberOfWidthdrawals, result.size());
    }

    /**
     * Test of getDeposits method, of class IAccountManager.
     */
    @Test
    public void testGetDeposits() {
        System.out.println("getDeposits");
        AccountIdentifier id = new AccountIdentifier("2");
        int expectedNumberOfWidthdrawals = 2;
        List<MovementDetails> result = manager.getDeposits(id);
        assertEquals(expectedNumberOfWidthdrawals, result.size());
    }

    /**
     * Test of deposit method, of class IAccountManager.
     */
    @Test
    public void testDeposit() throws NotFoundException {
        System.out.println("deposit");
        AccountIdentifier id = new AccountIdentifier("1");
        long amount = 1000;
        long expectedBalance = manager.getBalance(id) + amount;
        MovementDetails expResult = new MovementDetails("20/04/2020", 1000, "5");
        MovementDetails result = manager.deposit(amount, id);
        AccountDetails ad = manager.getAccount(id);
        
        assertEquals(expectedBalance, ad.getBalance());
        assertEquals(result.getClass(), expResult.getClass());
    }

    /**
     * Test of withdraw method, of class IAccountManager.
     */
    @Test
    public void testWithdraw() throws NotFoundException {
        System.out.println("withdraw");
        AccountIdentifier id = new AccountIdentifier("1");
        long amount = 1000;
        long expectedBalance = manager.getBalance(id) - amount;
        MovementDetails expResult = new MovementDetails("20/04/2020", 1000, "5");
        MovementDetails result = manager.withdraw(amount, id);
        AccountDetails ad = manager.getAccount(id);
        
        assertEquals(expectedBalance, ad.getBalance());
        assertEquals(result.getClass(), expResult.getClass());
    }

}
