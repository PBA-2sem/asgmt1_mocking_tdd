/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamwingitt.banking.contractTest;

import DTOs.AccountDetails;
import DTOs.BankDetails;
import DTOs.CustomerDetails;
import DTOs.identifiers.BankIdentifier;
import DTOs.identifiers.CustomerIdentifier;
import com.teamwingitt.banking.contract.IBankManager;
import exceptions.NotFoundException;
import java.util.ArrayList;
import java.util.List;
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
       manager = ManagerHolder.bankManager;
    }

    /**
     * Test of getBank method, of class IBankManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetBank() throws Exception {
        System.out.println("getBank");
        BankIdentifier id = new BankIdentifier("1");
        String expResult = "DanskeBank";
        BankDetails result = manager.getBank(id);
        assertEquals(expResult, result.getName());
    }

    /**
     * Test of getAccounts method, of class IBankManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAccounts() throws Exception {
       System.out.println("getAccounts - Bank");
         
       List<AccountDetails> accounts = new ArrayList<>();
       AccountDetails acc = new AccountDetails("DanskeBank", "Stanislav", "1234", 1337, null, null, "1");
       AccountDetails acc2 = new AccountDetails("DanskeBank", "Stanislav", "1234", 1337, null, null, "2");
       accounts.add(acc);
       accounts.add(acc2);
       
       CustomerIdentifier id = new CustomerIdentifier("1");
       List<AccountDetails> expResult = accounts;
       List<AccountDetails> result = manager.getAccounts(id);
       assertEquals(expResult.get(0).getBank(), result.get(0).getBank());
       assertEquals(expResult.size(), result.size());
       
       
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
