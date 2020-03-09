package implementations;

import dk.cphbusiness.banking.interfaces.Account;
import dk.cphbusiness.banking.interfaces.Bank;
import dk.cphbusiness.banking.interfaces.Customer;
import dk.cphbusiness.banking.interfaces.Movement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import exceptions.NotFoundException;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class CustomerImpl implements Customer {

    private final String cpr;
    private final String name;
    private final Bank bank;
    private final Map<String, Account> accounts = new HashMap<>();

    public CustomerImpl(String cpr, String name, Bank bank) {
        this.cpr = cpr;
        this.name = name;
        this.bank = bank;
    }

    @Override
    public void transfer(long amount, Account account, Account targetAccount) {
        account.transfer(amount, targetAccount);
    }

    @Override
    public String getCpr() {
        return cpr;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Bank getBank() {
        return bank;
    }

    @Override
    public Map<String, Account> getAccounts() {
        return this.accounts;
    }

    @Override
    public List<Movement> getListOfWithdrawal(String accNumber) throws NotFoundException {
        Account account = accounts.get(accNumber);
        if (account == null) throw new NotFoundException("Customer: " + this.cpr + " does not have account: " + accNumber);
        return account.getWithdrawals();
    }

    @Override
    public List<Movement> getListOfDeposits(String accNumber) throws NotFoundException {
        Account account = accounts.get(accNumber);
        if (account == null) throw new NotFoundException("Customer: " + this.cpr + " does not have account: " + accNumber);
        return account.getDeposits();
    }

    @Override
    public void addAccount(Account account) {
        this.accounts.put(account.getNumber(), account);
    }
}
