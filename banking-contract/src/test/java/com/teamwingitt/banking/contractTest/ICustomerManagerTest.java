/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamwingitt.banking.contractTest;

import DTOs.AccountDetails;
import DTOs.CustomerDetails;
import DTOs.identifiers.CustomerIdentifier;
import com.teamwingitt.banking.contract.ICustomerManager;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stanislavnovitski
 */
public class ICustomerManagerTest {

    ICustomerManager manager;

    public ICustomerManagerTest() {
        manager = ManagerHolder.customerManager;
    }

    /**
     * Test of getCustomer method, of class ICustomerManager.
     */
    @Test
    public void testGetCustomer() throws Exception {
        System.out.println("getCustomer");
        CustomerIdentifier id = new CustomerIdentifier("1");
        String expResult = "Jeff";
        CustomerDetails result = manager.getCustomer(id);
        assertEquals(expResult, result.getName());
    }

    /**
     * Test of getAccounts method, of class ICustomerManager.
     */
    @Test
    public void testGetAccounts() throws Exception {
        System.out.println("getAccounts");

        List<AccountDetails> accounts = new ArrayList<>();
        AccountDetails acc = new AccountDetails("Danske Bank", "Jeff", "1234", 1337, null, null, "1");
        AccountDetails acc2 = new AccountDetails("Danske Bank", "Jeff", "1234", 1337, null, null, "2");
        accounts.add(acc);
        accounts.add(acc2);

        CustomerIdentifier id = new CustomerIdentifier("1");
        List<AccountDetails> expResult = accounts;
        
        List<AccountDetails> result = manager.getAccounts(id);
        assertEquals(expResult.getClass(), result.getClass());
        assertEquals(expResult.size(), result.size());
        assertEquals(expResult.get(0).getCustomer(), result.get(0).getCustomer());

    }

}
