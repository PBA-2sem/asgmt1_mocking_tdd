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
        String expectedCustomerName = "Jeff";

        AccountDetails result = manager.getAccount(id);

        assertNotNull(result);
        assertEquals(result.getClass(), AccountDetails.class);
        assertEquals(expectedName, result.getBank());
        assertEquals(expectedCustomerName, result.getCustomer());
    }

    /**
     * Test of getBalance method, of class IAccountManager.
     */
    @Test
    public void testGetBalance() throws NotFoundException{
        System.out.println("deposit");
        AccountIdentifier id = new AccountIdentifier("2");
        long expectedBalance = 20;
        assertEquals(expectedBalance, manager.getBalance(id));
    }

    /**
     * Test of transfer method, of class IAccountManager.
     */
    @Test
    public void testTransferWithAccount() throws Exception {
        System.out.println("transferWithAccount");
        AccountIdentifier jeff = new AccountIdentifier("1");
        AccountIdentifier mathias = new AccountIdentifier("2");
        long amount = 10L;
        long expectedBalanaceForJeff = 10;
        long expectedBalanaceForMathias = 30;
        String sourceAccNumber = "1"; //Jeff
        String targetAccNumber = "2"; //Mathias
        manager.transfer(amount, sourceAccNumber, targetAccNumber);
        assertEquals(expectedBalanaceForJeff, manager.getBalance(jeff));
        assertEquals(expectedBalanaceForMathias, manager.getBalance(mathias));
    }

    /**
     * Test of transfer method, of class IAccountManager.
     */
    @Test
    public void testTransferWithAccountNumber() throws Exception {
        System.out.println("transferWithAccountNumber");
        AccountIdentifier jeff = new AccountIdentifier("1");
        AccountIdentifier mathias = new AccountIdentifier("2");
        long amount = 10L;
        long expectedBalanaceForJeff = 0;
        long expectedBalanaceForMathias = 40;
        String sourceAccNumber = "1"; //jeff
        String targetAccNumber = "2"; //mathias
        manager.transfer(amount, sourceAccNumber, targetAccNumber);
        assertEquals(expectedBalanaceForJeff, manager.getBalance(jeff));
        assertEquals(expectedBalanaceForMathias, manager.getBalance(mathias));
    }

    /**
     * Test of getWithdrawals method, of class IAccountManager.
     */
    @Test
    public void testGetWithdrawals() throws NotFoundException{
        System.out.println("getWithdrawals");
        AccountIdentifier id = new AccountIdentifier("1");
        int expectedNumberOfWidthdrawals = 2;
        List<MovementDetails> result = manager.getWithdrawals(id);
        assertEquals(expectedNumberOfWidthdrawals, result.size());
    }

    /**
     * Test of getDeposits method, of class IAccountManager.
     */
    @Test
    public void testGetDeposits() throws NotFoundException{
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
