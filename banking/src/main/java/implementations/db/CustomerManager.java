/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementations.db;

import DTOs.AccountDetails;
import DTOs.CustomerDetails;
import DTOs.identifiers.CustomerIdentifier;
import com.teamwingitt.banking.contract.ICustomerManager;
import dao.CustomerDAO;
import dk.cphbusiness.banking.interfaces.Account;
import dk.cphbusiness.banking.interfaces.Customer;
import dto.mappers.AccountMapper;
import dto.mappers.CustomerMapper;
import exceptions.NotFoundException;
import implementations.CustomerImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andreas
 */
public class CustomerManager implements ICustomerManager{

    CustomerMapper customerMapper = new CustomerMapper();
    AccountMapper accountMapper = new AccountMapper();
    CustomerDAO customerDAO = new CustomerDAO();
    
    
    
    
    
    @Override
    public CustomerDetails getCustomer(CustomerIdentifier id) throws NotFoundException {
        return customerMapper.fromInternal((Customer) customerDAO.getCustomerDB(id.getId()));
    }

    @Override
    public List<AccountDetails> getAccounts(CustomerIdentifier id) throws NotFoundException {
      List<AccountDetails> accounts = (List<AccountDetails>) accountMapper.fromInternal((Account) customerDAO.getAccountsDB(id.getId()));
      return accounts;
         
    }
    
}
