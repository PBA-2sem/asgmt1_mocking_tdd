package dk.cphbusiness.banking.interfaces;

import exceptions.NotFoundException;
import java.util.List;

/**
 * This is an interface for Account.
 *
 */
public interface Account {

    /**
     * This method will be used to get the Bank of the Account.
     *
     * @return the Bank of the Account.
     */
    Bank getBank();

    /**
     * This method will be used to get the Customer of the Account.
     *
     * @return the Customer of the Account.
     */
    Customer getCustomer();

    /**
     * This method will be used to get the Account number.
     *
     * @return the Account number.
     */
    String getNumber();

    /**
     * This method will be used to transfer given amount of money to given
     * Account.
     *
     * @param amount of money
     * @param target Account
     */
    void transfer(long amount, Account target);

    /**
     * This method will be used to transfer given amount of money to given
     * target account number. Acts as a wrapper around transfer(long amount,
     * Account target)
     *
     * @param amount of money
     * @param targetNumber target account number
     * @throws exceptions.NotFoundException
     */
    void transfer(long amount, String targetNumber) throws NotFoundException;

    /**
     * This method will be used to get Account balance.
     *
     * @return amount of money
     */
    long getBalance();

    /**
     * This method will be used to get a List of Movement, representing Account
     * withdrawals.
     *
     * @return List of Movement
     */
    List<Movement> getWithdrawals();

    /**
     * This method will be used to get a List of Movement, representing Account
     * deposits.
     *
     * @return List of Movement
     */
    List<Movement> getDeposits();

    /**
     * This method adds the amount to the balance
     * 
     * @param amount
     */
    void deposit(long amount);

    /**
     * This method reduces the amount from the balance
     * 
     * @param amount
     */
    void withdraw(long amount);

}
