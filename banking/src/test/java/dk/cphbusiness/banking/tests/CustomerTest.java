/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.banking.tests;

import dk.cphbusiness.banking.interfaces.Account;
import dk.cphbusiness.banking.interfaces.Bank;
import dk.cphbusiness.banking.interfaces.Customer;
import implementations.AccountImpl;
import org.jmock.integration.junit4.JUnitRuleMockery;
import implementations.CustomerImpl;
import static org.jmock.AbstractExpectations.returnValue;
import org.jmock.Expectations;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 *
 * @author Andreas
 */
public class CustomerTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void testCustomerGetName() {
        final Bank bank = context.mock(Bank.class);
        final String cName = "Andreas";
        final String cCpr = "123456789";

        Customer customer = new CustomerImpl(cCpr, cName, bank);
//            context.checking(new Expectations() {
//            {
//               //oneOf(customer).getName();
//               // will(returnValue(customer.getName()));
//            }
//        });
        assertEquals(cCpr, customer.getCpr());
        assertEquals(cName, customer.getName());

    }

    @Test
    public void testCustomerTransfer() {
        final Bank bank = context.mock(Bank.class);
        
        final String cName = "Andreas";
        final String cCpr = "123456789";
        
        Customer c = new CustomerImpl(cCpr, cName, bank);
               
        final String targetNumber = "TGT54321";
        Account source = new AccountImpl(bank, c, "SRC54321");
        Account target = new AccountImpl(bank, c, targetNumber);
                     
        context.checking(new Expectations() {
            {
                atLeast(1).of(bank).getAccount(source.getNumber()); 
                will(returnValue(source));
                
              //  oneOf(account).transfer(10000, target);
            }
        });
        c.transfer(10000, source, target);
        
        assertEquals(-10000, source.getBalance());
        assertEquals(10000, target.getBalance());
        
    }

}
