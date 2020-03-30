package com.teamwingitt.banking.contract;

import DTOs.AccountDetails;
import DTOs.BankDetails;
import DTOs.identifiers.BankIdentifier;
import DTOs.identifiers.CustomerIdentifier;
import exceptions.NotFoundException;
import java.util.List;

/**
 * This is an interface for Bank.
 *
 */
public interface IBankManager {

    /**
     * Returns bank by id
     *
     * @param id
     * @return BankDetails
     * @throws NotFoundException
     */
    BankDetails getBank(BankIdentifier id) throws NotFoundException;

    /**
     * This method will be used to get all accounts from given Customer id.
     *
     * @param id the given Customer id
     * @return the Map<String,AccountDetails> of corresponding accounts
     */
    List<AccountDetails> getAccounts(CustomerIdentifier id) throws NotFoundException;

}
