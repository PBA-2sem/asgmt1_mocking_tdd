/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.banking.contractTests;

import DTOs.AccountDetails;
import DTOs.CustomerDetails;
import DTOs.MovementDetails;
import DTOs.identifiers.CustomerIdentifier;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.teamwingitt.banking.contract.IAccountManager;
import com.teamwingitt.banking.contract.ICustomerManager;
import exceptions.NotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Andreas
 */
public class CustomerManagerDummy implements ICustomerManager {
    
     Map<String, CustomerDetails> dummyCustomers = new HashMap<>();
     
       
     List<AccountDetails> accounts = new ArrayList<>();
     
     public CustomerManagerDummy(){
         
         CustomerDetails stanislav = new CustomerDetails("128923-1111", "Stanislav", "DanskeBank", "1");
         CustomerDetails andreas = new CustomerDetails("11112222-3333", "Andreas", "Nordea", "2");
                 
         dummyCustomers.put("1", stanislav);
         dummyCustomers.put("2", andreas);
        
         AccountDetails acc = new AccountDetails(stanislav.getBank(), stanislav.getName(), "1234", 1337, null, null, "1");
         AccountDetails acc2 = new AccountDetails(stanislav.getBank(), stanislav.getName(), "1234", 1337, null, null, "2");
         
       
         accounts.add(acc);
         accounts.add(acc2);
      
     }


    @Override
    public CustomerDetails getCustomer(CustomerIdentifier id) throws NotFoundException {
        return dummyCustomers.get(id.getId());
    }

    @Override
    public List<AccountDetails> getAccounts(CustomerIdentifier id) throws NotFoundException {
        return this.accounts;
    }



    

  
    
    
}
