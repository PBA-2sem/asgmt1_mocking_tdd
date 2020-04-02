package implementations.db;

import DTOs.AccountDetails;
import DTOs.BankDetails;
import DTOs.identifiers.BankIdentifier;
import DTOs.identifiers.CustomerIdentifier;
import com.teamwingitt.banking.contract.IBankManager;
import dao.BankDAO;
import dk.cphbusiness.banking.interfaces.Bank;
import dto.mappers.AccountMapper;
import dto.mappers.BankMapper;
import exceptions.NotFoundException;
import implementations.AccountImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class BankManager implements IBankManager {

    BankMapper bankmapper = new BankMapper();
    AccountMapper accountMapper = new AccountMapper();
    BankDAO bankDAO = new BankDAO();

    @Override
    public BankDetails getBank(BankIdentifier id) throws NotFoundException {
        return bankmapper.fromInternal((Bank) bankDAO.read(id.getId()));
    }

    @Override
    public List<AccountDetails> getAccounts(CustomerIdentifier id) throws NotFoundException {
        //TODO
        List<AccountImpl> accountsInternal = bankDAO.getAccounts(id);
        List<AccountDetails> accounts = new ArrayList<>();
        //accountsInternal.forEach((a) -> accounts.add(accountMapper.fromInternal()));
        return accounts;
    }
}
