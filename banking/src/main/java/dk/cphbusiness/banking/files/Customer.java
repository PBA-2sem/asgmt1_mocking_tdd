package dk.cphbusiness.banking.files;

import java.util.List;
import java.util.Map;

public interface Customer {
    void transfer(long amount, Account account, Account targetAccount);
    String getCpr();
    String getName();
    Bank getBank();
    Map<String, Account> getAccounts();
    List<Movement> getListOfWithdrawal(int accNumber);
    List<Movement> getListOfDeposits(int accNumber);
}