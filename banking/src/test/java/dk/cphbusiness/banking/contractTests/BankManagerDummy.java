package dk.cphbusiness.banking.contractTests;

import DTOs.AccountDetails;
import DTOs.BankDetails;
import DTOs.identifiers.BankIdentifier;
import DTOs.identifiers.CustomerIdentifier;
import com.teamwingitt.banking.contract.IBankManager;
import dk.cphbusiness.banking.interfaces.Account;
import dto.mappers.AccountMapper;
import dto.mappers.BankMapper;
import dto.mappers.MovementMapper;
import exceptions.NotFoundException;
import implementations.AccountImpl;
import implementations.BankImpl;
import implementations.CustomerImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Andreas
 */
public class BankManagerDummy implements IBankManager {

    BankImpl bank;
    CustomerImpl jeff;
    CustomerImpl mathias;
    AccountImpl accJeff;
    AccountImpl accMathias;
    AccountMapper accMapper;
    MovementMapper moveMapper;
    BankMapper bankMapper;

    public BankManagerDummy() {
        accMapper = new AccountMapper();
        moveMapper = new MovementMapper();
        bankMapper = new BankMapper();
        bank = new BankImpl("1", "DanskeBank");
        jeff = new CustomerImpl("1", "Jeff", bank);
        accJeff = new AccountImpl(bank, jeff, "1");
        bank.addAccount(accJeff);
//    
    }

    @Override
    public BankDetails getBank(BankIdentifier id) throws NotFoundException {
        return bankMapper.fromInternal(bank);
    }

    @Override
    public List<AccountDetails> getAccounts(CustomerIdentifier id) throws NotFoundException {
        Map<String, Account> accs = bank.getAccounts(jeff);
        List<AccountDetails> accDetailsList = new ArrayList();
        for (Account acc : accs.values()) {
            accDetailsList.add(accMapper.fromInternal(acc));
        }
        return accDetailsList;
    }

}
