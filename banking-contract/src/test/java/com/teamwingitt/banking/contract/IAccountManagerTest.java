package com.teamwingitt.banking.contract;

import DTOs.AccountDetails;
import DTOs.MovementDetails;
import DTOs.identifiers.AccountIdentifier;
import exceptions.NotFoundException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class IAccountManagerTest {

    /**
     * Test of getAccount method, of class IAccountManager.
     */
    @Test
    public void testGetAccount() throws Exception {
        System.out.println("getAccount");
        AccountIdentifier id = null;
        IAccountManager instance = new IAccountManagerImpl();
        AccountDetails expResult = null;
        AccountDetails result = instance.getAccount(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        IAccountManager instance = new IAccountManagerImpl();
        instance.transfer(amount, source, target);
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
        IAccountManager instance = new IAccountManagerImpl();
        instance.transfer(amount, sourceAccNumber, targetAccNumber);
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
        IAccountManager instance = new IAccountManagerImpl();
        long expResult = 0L;
        long result = instance.getBalance(id);
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
        IAccountManager instance = new IAccountManagerImpl();
        List<MovementDetails> expResult = null;
        List<MovementDetails> result = instance.getWithdrawals(id);
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
        IAccountManager instance = new IAccountManagerImpl();
        List<MovementDetails> expResult = null;
        List<MovementDetails> result = instance.getDeposits(id);
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
        IAccountManager instance = new IAccountManagerImpl();
        MovementDetails expResult = null;
        MovementDetails result = instance.deposit(amount, id);
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
        IAccountManager instance = new IAccountManagerImpl();
        MovementDetails expResult = null;
        MovementDetails result = instance.withdraw(amount, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IAccountManagerImpl implements IAccountManager {

        public AccountDetails getAccount(AccountIdentifier id) throws NotFoundException {
            return null;
        }

        public void transfer(long amount, AccountIdentifier source, AccountIdentifier target) throws NotFoundException {
        }

        public void transfer(long amount, String sourceAccNumber, String targetAccNumber) throws NotFoundException {
        }

        public long getBalance(AccountIdentifier id) {
            return 0L;
        }

        public List<MovementDetails> getWithdrawals(AccountIdentifier id) {
            return null;
        }

        public List<MovementDetails> getDeposits(AccountIdentifier id) {
            return null;
        }

        public MovementDetails deposit(long amount, AccountIdentifier id) {
            return null;
        }

        public MovementDetails withdraw(long amount, AccountIdentifier id) {
            return null;
        }
    }

}
