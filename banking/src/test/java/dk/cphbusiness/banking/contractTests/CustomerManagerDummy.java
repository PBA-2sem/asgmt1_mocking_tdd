/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.banking.contractTests;

import DTOs.AccountDetails;
import DTOs.CustomerDetails;
import DTOs.identifiers.CustomerIdentifier;
import com.teamwingitt.banking.contract.ICustomerManager;
import dk.cphbusiness.banking.interfaces.Account;
import dto.mappers.AccountMapper;
import dto.mappers.CustomerMapper;
import exceptions.NotFoundException;
import implementations.AccountImpl;
import implementations.BankImpl;
import implementations.CustomerImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Andreas
 */
public class CustomerManagerDummy implements ICustomerManager {

    CustomerMapper cusMapper;
    AccountMapper accMapper;
    BankImpl bank;
    CustomerImpl stanislav;
    AccountImpl accJeff;
    AccountImpl accJeff2;

    public CustomerManagerDummy() {

        cusMapper = new CustomerMapper();
        accMapper = new AccountMapper();
        bank = new BankImpl("1", "DanskeBank");
        stanislav = new CustomerImpl("1", "Stanislav", bank);
        accJeff = new AccountImpl(bank, stanislav, "1");
        accJeff2 = new AccountImpl(bank, stanislav, "2");
        stanislav.addAccount(accJeff);
        stanislav.addAccount(accJeff2);

    }

    @Override
    public CustomerDetails getCustomer(CustomerIdentifier id) throws NotFoundException {
        return cusMapper.fromInternal(stanislav);

    }

    @Override
    public List<AccountDetails> getAccounts(CustomerIdentifier id) throws NotFoundException {
        Map<String, Account> accs = stanislav.getAccounts();
        List<AccountDetails> accDetailsList = new ArrayList();
        for (Account acc : accs.values()) {
            accDetailsList.add(accMapper.fromInternal(acc));
        }
        return accDetailsList;
    }

}
