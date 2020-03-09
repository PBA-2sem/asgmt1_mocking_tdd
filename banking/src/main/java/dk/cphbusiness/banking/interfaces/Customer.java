package dk.cphbusiness.banking.interfaces;

import exceptions.NotFoundException;
import java.util.List;
import java.util.Map;

/**
 * This is an interface for Customer.
 *
 */
public interface Customer {

    /**
     * This methods will be used to transfer amount from given account to target
     * account.
     *
     * @param amount
     * @param account
     * @param targetAccount
     */
    void transfer(long amount, Account account, Account targetAccount) throws NotFoundException;

    /**
     * This methods will be used to get cpr of Customer.
     *
     * @return cpr as String
     */
    String getCpr();

    /**
     * This methods will be used to get name of Customer.
     *
     * @return name as String
     */
    String getName();

    /**
     * This methods will be used to get Bank of Customer.
     *
     * @return Bank
     */
    Bank getBank();

    /**
     * This methods will be used to get all Customer Accounts.
     *
     * @return Map of account numbers & accounts
     */
    Map<String, Account> getAccounts();

    /**
     * This method adds account to map
     *
     * @param account account to add
     */
    void addAccount(Account account);

    /**
     * This method will be used to get a List of Movement, representing Account
     * withdrawals, by given account number.
     *
     * @param accNumber
     * @return List of Movement
     * @throws exceptions.NotFoundException
     */
    List<Movement> getListOfWithdrawal(String accNumber) throws NotFoundException;

    /**
     * This method will be used to get a List of Movement, representing Account
     * deposits, by given account number.
     *
     * @param accNumber
     * @return List of Movement
     * @throws exceptions.NotFoundException
     */
    List<Movement> getListOfDeposits(String accNumber) throws NotFoundException;
}
