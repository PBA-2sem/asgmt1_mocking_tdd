package com.teamwingitt.banking.contractTest;

import DTOs.AccountDetails;
import DTOs.MovementDetails;
import DTOs.identifiers.AccountIdentifier;
import com.teamwingitt.banking.contract.IAccountManager;
import exceptions.NotFoundException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testTransfer_3args_1() throws Exception {
        System.out.println("transfer");
        long amount = 0L;
        AccountIdentifier source = null;
        AccountIdentifier target = null;
        manager.transfer(amount, source, target);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transfer method, of class IAccountManager.
     */
    @Test
    public void testTransfer_3args_2() throws Exception {
        System.out.println("transfer");
        long amount = 0L;
        String sourceAccNumber = "";
        String targetAccNumber = "";
        manager.transfer(amount, sourceAccNumber, targetAccNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBalance method, of class IAccountManager.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        AccountIdentifier id = null;
        long expResult = 0L;
        long result = manager.getBalance(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWithdrawals method, of class IAccountManager.
     */
    @Test
    public void testGetWithdrawals() {
        System.out.println("getWithdrawals");
        AccountIdentifier id = null;
        List<MovementDetails> expResult = null;
        List<MovementDetails> result = manager.getWithdrawals(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeposits method, of class IAccountManager.
     */
    @Test
    public void testGetDeposits() {
        System.out.println("getDeposits");
        AccountIdentifier id = null;
        List<MovementDetails> expResult = null;
        List<MovementDetails> result = manager.getDeposits(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deposit method, of class IAccountManager.
     */
    @Test
    public void testDeposit() {
        System.out.println("deposit");
        long amount = 0L;
        AccountIdentifier id = null;
        MovementDetails expResult = null;
        MovementDetails result = manager.deposit(amount, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of withdraw method, of class IAccountManager.
     */
    @Test
    public void testWithdraw() {
        System.out.println("withdraw");
        long amount = 0L;
        AccountIdentifier id = null;
        MovementDetails expResult = null;
        MovementDetails result = manager.withdraw(amount, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
