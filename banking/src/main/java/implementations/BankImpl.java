package implementations;

import dk.cphbusiness.banking.interfaces.Account;
import dk.cphbusiness.banking.interfaces.Bank;
import dk.cphbusiness.banking.interfaces.Customer;
import java.util.Map;

/**
 *
 * @author awha8
 */
public class BankImpl implements Bank {
    
    private final String cvr;
    private final String name;
    private final Map<String, Account> accounts;
    
    public BankImpl(String cvr, String name, Map<String, Account> accounts) {
        this.cvr = cvr;
        this.name = name;
        this.accounts = accounts;
    }
    
    @Override
    public String getCvr() {
        return cvr;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public Account getAccount(String number) {
        return accounts.get(number);
    }
    
    @Override
    public void addAccount(Account account) {
        accounts.put(account.getNumber(), account);
        account.getCustomer().addAccount(account);
    }
    
    @Override
    public Map<String, Account> getAccounts(Customer customer) {
        return customer.getAccounts();
    }
}
