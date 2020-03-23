package com.teamwingitt.banking.contract;

import DTOs.AccountDetails;
import DTOs.MovementDetails;
import DTOs.identifiers.AccountIdentifier;

import exceptions.NotFoundException;
import java.util.List;

/**
 * This is an interface for Account.
 *
 */
public interface IAccountManager {

    /**
     * This method returns account details based on id
     *
     * @param id
     * @return AccountDetails
     */
    AccountDetails getAccount(AccountIdentifier id) throws NotFoundException;

    /**
     * This method will be used to transfer given amount of money to given
     * Account.
     *
     * @param amount of money
     * @param source target account number
     * @param target Account id
     */
    void transfer(long amount, AccountIdentifier source, AccountIdentifier target) throws NotFoundException;

    /**
     * This method will be used to transfer given amount of money to given
     * target account number. Acts as a wrapper around transfer(long amount,
     * Account target)
     *
     * @param amount of money
     * @param sourceAccNumber target account number
     * @param targetAccNumber target account number
     * @throws exceptions.NotFoundException
     */
    void transfer(long amount, String sourceAccNumber, String targetAccNumber) throws NotFoundException;

    /**
     * This method will be used to get Account balance.
     *
     * @return amount of money
     * @param id account id
     */
    long getBalance(AccountIdentifier id);

    /**
     * This method will be used to get a List of Movement, representing Account
     * withdrawals.
     *
     * @param id account id
     * @return List of MovementDetails
     */
    List<MovementDetails> getWithdrawals(AccountIdentifier id);

    /**
     * This method will be used to get a List of Movement, representing Account
     * deposits.
     *
     * @param id account id
     * @return List of MovementDetails
     */
    List<MovementDetails> getDeposits(AccountIdentifier id);

    /**
     * This method adds the amount to the balance
     *
     * @param id account id
     * @param amount
     * @return MovementDetails
     */
    MovementDetails deposit(long amount, AccountIdentifier id);

    /**
     * This method reduces the amount from the balance
     *
     * @param id account id
     * @param amount
     * @return MovementDetails
     */
    MovementDetails withdraw(long amount, AccountIdentifier id);

}
