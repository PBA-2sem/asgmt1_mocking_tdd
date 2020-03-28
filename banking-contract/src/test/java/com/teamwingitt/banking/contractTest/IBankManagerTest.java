/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamwingitt.banking.contractTest;

import DTOs.AccountDetails;
import DTOs.BankDetails;
import DTOs.identifiers.BankIdentifier;
import DTOs.identifiers.CustomerIdentifier;
import com.teamwingitt.banking.contract.IBankManager;
import exceptions.NotFoundException;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stanislavnovitski
 */
public class IBankManagerTest {

    IBankManager manager;

    public IBankManagerTest() {
        this.manager = ManagerHolder.bankManager;
    }

    /**
     * Test of getBank method, of class IBankManager.
     */
    @Test
    public void testGetBank() throws Exception {
        System.out.println("getBank");
        BankIdentifier id = null;
        BankDetails expResult = null;
        BankDetails result = manager.getBank(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccounts method, of class IBankManager.
     */
    @Test
    public void testGetAccounts() throws Exception {
        System.out.println("getAccounts");
        CustomerIdentifier id = null;
        Map<String, AccountDetails> expResult = null;
        Map<String, AccountDetails> result = manager.getAccounts(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAccount method, of class IBankManager.
     */
    @Test
    public void testAddAccount() {
        System.out.println("addAccount");
        AccountDetails account = null;
        AccountDetails expResult = null;
        AccountDetails result = manager.addAccount(account);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
