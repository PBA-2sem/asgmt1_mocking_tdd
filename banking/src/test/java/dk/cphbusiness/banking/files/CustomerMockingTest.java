/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.banking.files;

import dk.cphbusiness.banking.files.fakes.AccountFake;
import org.jmock.integration.junit4.JUnitRuleMockery;
import dk.cphbusiness.banking.files.fakes.CustomerFake;
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
public class CustomerMockingTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void testCustomer() {
        final Bank bank = context.mock(Bank.class);
        final String cName = "Andreas";
        final String cCpr = "123456789";

        Customer customer = new CustomerFake(cCpr, cName, bank);
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
        final Account account = context.mock(Account.class);
        final Bank bank = context.mock(Bank.class);
        final Customer customer = context.mock(Customer.class);
        System.out.println("Hej1");
        
        
        final String targetNumber = "TGT54321";
        Account source = new AccountFake(bank, customer, "SRC54321");
        Account target = new AccountFake(bank, customer, targetNumber);
        
        context.checking(new Expectations() {
            {
                oneOf(customer).transfer(10000, source, target);
                
                oneOf(bank).getAccount(targetNumber);
                will(returnValue(target));
//                
                oneOf(account).transfer(10000, target);
                will(returnValue(target));
              
                
            }
        });
        customer.transfer(10000, source, target);
        
        assertEquals(-10000, source.getBalance());
        assertEquals(10000, target.getBalance());
        
    }

}
