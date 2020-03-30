package dk.cphbusiness.banking.interfaces;

import exceptions.NotFoundException;
import java.util.Map;

/**
 * This is an interface for Bank.
 *
 */
public interface Bank {

    /**
     * This method will be used to get the Bank cvr.
     *
     * @return the Bank cvr
     */
    String getCvr();

    /**
     * This method will be used to get the Bank name.
     *
     * @return the Bank name.
     */
    String getName();

    /**
     * This method will be used to get Bank account by account number.
     *
     * @param number account number
     * @return the corresponding Account
     * @throws exceptions.NotFoundException
     */
    Account getAccount(String number) throws NotFoundException;

    /**
     * This method will be used to get all accounts from given Customer.
     *
     * @param customer the given Customer
     * @return the Map<String,Account> of corresponding accounts
     */
    Map<String, Account> getAccounts(Customer customer);

    /**
     * This method will be used to add an Account.
     *
     * @param account the given Account
     */
    void addAccount(Account account);
    
    void addCustomer(Customer customer);
}
