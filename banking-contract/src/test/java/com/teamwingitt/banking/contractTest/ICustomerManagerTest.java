/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamwingitt.banking.contractTest;

import DTOs.CustomerDetails;
import DTOs.identifiers.CustomerIdentifier;
import com.teamwingitt.banking.contract.IAccountManager;
import com.teamwingitt.banking.contract.ICustomerManager;
import exceptions.NotFoundException;
import java.util.Map;
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
        CustomerIdentifier id = null;
        CustomerDetails expResult = null;
        CustomerDetails result = manager.getCustomer(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccounts method, of class ICustomerManager.
     */
    @Test
    public void testGetAccounts() throws Exception {
        System.out.println("getAccounts");
        CustomerIdentifier id = null;
        Map<String, IAccountManager> expResult = null;
        Map<String, IAccountManager> result = manager.getAccounts(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
