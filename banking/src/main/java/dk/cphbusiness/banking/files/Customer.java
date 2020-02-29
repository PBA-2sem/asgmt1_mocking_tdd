package dk.cphbusiness.banking.files;

import java.util.List;
import java.util.Map;

public interface Customer {
    void transfer(int amount, Account account, Account targetAccount);
    String getCpr();
    String getName();
    Bank getBank();
    Map<String, Account> getAccounts();
    List<Movement> getListOfWithdrawal(int number);
    List<Movement> getListOfDeposits(int number);
}