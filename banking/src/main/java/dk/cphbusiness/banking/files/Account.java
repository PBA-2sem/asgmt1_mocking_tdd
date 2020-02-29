package dk.cphbusiness.banking.files;

import java.util.List;

public interface Account {
    
    Bank getBank();
    Customer getCustomer();
    String getNumber();
    void transfer(long amount, Account target);
    void transfer(long amount, String targetNumber);
    long getBalance();
    List<Movement> getWithdrawals();
    List<Movement> getDeposits();
    void setBalance(long amount);
}