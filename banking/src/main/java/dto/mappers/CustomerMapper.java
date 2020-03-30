/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mappers;

import DTOs.CustomerDetails;
import dk.cphbusiness.banking.interfaces.Customer;

/**
 *
 * @author Andreas
 */
public class CustomerMapper implements Mapper<Customer, CustomerDetails>{

    @Override
    public CustomerDetails fromInternal(Customer object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer toInternal(CustomerDetails object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
