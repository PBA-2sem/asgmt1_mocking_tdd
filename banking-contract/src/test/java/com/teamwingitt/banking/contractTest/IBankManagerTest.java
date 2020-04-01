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
import java.util.ArrayList;
import java.util.List;
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
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetBank() throws Exception {
        System.out.println("getBank");
        BankIdentifier id = new BankIdentifier("1");
        String expResult = "Danske Bank";
        BankDetails result = manager.getBank(id);
        assertEquals(expResult, result.getName());
    }

    /**
     * Test of getAccounts method, of class IBankManager.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAccounts() throws Exception {
        System.out.println("getAccounts - Bank");

        List<AccountDetails> accounts = new ArrayList<>();
        AccountDetails acc = new AccountDetails("Danske Bank", "Jeff", "1", 20, null, null, "1");
        accounts.add(acc);
        CustomerIdentifier id = new CustomerIdentifier("1");
        String expResult = "Danske Bank";
        int expSize = 1;

        List<AccountDetails> result = manager.getAccounts(id);
        
        assertEquals(expResult, result.get(0).getBank());
        assertEquals(expSize, result.size());
    }

}
