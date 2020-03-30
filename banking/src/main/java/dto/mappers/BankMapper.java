/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.mappers;

import DTOs.BankDetails;
import dk.cphbusiness.banking.interfaces.Bank;

/**
 *
 * @author Andreas
 */
public class BankMapper implements Mapper<Bank, BankDetails>{

    @Override
    public BankDetails fromInternal(Bank object) {
        return new BankDetails(object.getName(), object.getCvr(), object.getCvr());
        
    }

    @Override
    public Bank toInternal(BankDetails object) {
    return null;
    }
    
}
