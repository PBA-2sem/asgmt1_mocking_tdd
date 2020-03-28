package com.teamwingitt.banking.contract;

import DTOs.AccountDetails;
import DTOs.CustomerDetails;
import DTOs.identifiers.CustomerIdentifier;
import exceptions.NotFoundException;
import java.util.List;
import java.util.Map;

/**
 * This is an interface for Customer.
 *
 */
public interface ICustomerManager {

    /**
     * Returns customer by id
     *
     * @param id
     * @return CustomerDetails
     * @throws NotFoundException
     */
    CustomerDetails getCustomer(CustomerIdentifier id) throws NotFoundException;

    /**
     * This methods will be used to get all Customer Accounts.
     *
     * @param id customer id
     * @return Map of account numbers & accounts
     * @throws NotFoundException
     */
    List<AccountDetails> getAccounts(CustomerIdentifier id) throws NotFoundException;
    

}
