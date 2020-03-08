package dk.cphbusiness.banking.files.fakes;

import dk.cphbusiness.banking.files.Account;
import dk.cphbusiness.banking.files.Bank;
import dk.cphbusiness.banking.files.Customer;
import dk.cphbusiness.banking.files.Movement;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class CustomerFake implements Customer {

    private final String cpr;
    private final String name;
    private final Bank bank;
    

    public CustomerFake(String cpr, String name, Bank bank) {
        this.cpr = cpr;
        this.name = name;
        this.bank = bank;
    }

    @Override
    public void transfer(long amount, Account account, Account targetAccount) {
        Account thisAccount = bank.getAccount(account.getNumber());
        thisAccount.transfer(amount, targetAccount);
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
        return bank.getAccounts(this);
    }

    @Override
    public List<Movement> getListOfWithdrawal(int number) {
        return bank.getAccount(this.name).getWithdrawals();
    }

    @Override
    public List<Movement> getListOfDeposits(int number) {
        return bank.getAccount(this.name).getDeposits();
    }
}
