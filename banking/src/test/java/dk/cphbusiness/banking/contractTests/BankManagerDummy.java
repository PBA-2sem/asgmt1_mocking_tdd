
package dk.cphbusiness.banking.contractTests;

import DTOs.AccountDetails;
import DTOs.BankDetails;
import DTOs.identifiers.BankIdentifier;
import DTOs.identifiers.CustomerIdentifier;
import com.teamwingitt.banking.contract.IBankManager;
import dto.mappers.AccountMapper;
import dto.mappers.BankMapper;
import dto.mappers.MovementMapper;
import exceptions.NotFoundException;
import implementations.AccountImpl;
import implementations.BankImpl;
import implementations.CustomerImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Andreas
 */
public class BankManagerDummy implements IBankManager{
    BankImpl bank;
    CustomerImpl jeff;
    CustomerImpl mathias;
    AccountImpl accJeff;
    AccountImpl accMathias;
    AccountMapper accMapper;
    MovementMapper moveMapper;
    BankMapper bankMapper;
    
    public BankManagerDummy(){
        accMapper = new AccountMapper();
        moveMapper = new MovementMapper();
        bankMapper = new BankMapper();
        bank = new BankImpl("1", "DanskeBank");
        jeff = new CustomerImpl("1", "Jeff", bank);
        mathias = new CustomerImpl("2", "Mathias", bank);
        accJeff = new AccountImpl(bank, jeff, "1");
        accMathias = new AccountImpl(bank, mathias, "2");
        bank.addAccount(accJeff);
        bank.addAccount(accMathias);
//    
    }

    @Override
    public BankDetails getBank(BankIdentifier id) throws NotFoundException {
        return bankMapper.fromInternal(bank);
    }

    @Override
    public List<AccountDetails> getAccounts(CustomerIdentifier id) throws NotFoundException {
       // bank.getAccounts(id.getId());
        return null;
    }


  
    
}
