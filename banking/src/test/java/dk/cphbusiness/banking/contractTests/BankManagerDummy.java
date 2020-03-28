
package dk.cphbusiness.banking.contractTests;

import DTOs.AccountDetails;
import DTOs.BankDetails;
import DTOs.identifiers.BankIdentifier;
import DTOs.identifiers.CustomerIdentifier;
import com.teamwingitt.banking.contract.IBankManager;
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
public class BankManagerDummy implements IBankManager{
    
    Map<String, BankDetails> dummyBanks = new HashMap<>();   
    List<AccountDetails> accounts = new ArrayList<>();
    public BankManagerDummy(){
        
        
        BankDetails bank = new BankDetails("DanskeBank", "310912409214", "1");
        BankDetails bank2 = new BankDetails("Danske", "310912409214", "2");
    
        dummyBanks.put("1", bank);
        dummyBanks.put("2", bank2);
        AccountDetails acc = new AccountDetails("DanskeBank", "Stanislav", "1234", 1337, null, null, "1");
        AccountDetails acc2 = new AccountDetails("Nordea", "Andreas", "4321", 420, null, null, "2");
         
       
         accounts.add(acc);
         accounts.add(acc2);
    
    }

    @Override
    public BankDetails getBank(BankIdentifier id) throws NotFoundException {
        return dummyBanks.get(id.getId());
    }

    @Override
    public List<AccountDetails> getAccounts(CustomerIdentifier id) throws NotFoundException {
        return this.accounts;
    }


  
    
}
