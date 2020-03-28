package dk.cphbusiness.banking.contractTests;

import DTOs.AccountDetails;
import DTOs.MovementDetails;
import DTOs.identifiers.AccountIdentifier;
import com.teamwingitt.banking.contract.IAccountManager;
import exceptions.NotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountManagerDummy implements IAccountManager {

    Map<String, AccountDetails> dummyAccounts = new HashMap<>();

    public AccountManagerDummy() {
        AccountDetails stanislav = new AccountDetails("DanskeBank", "Stanislav", "1234", 1337,
                new ArrayList<MovementDetails>() {
            {
                add(new MovementDetails("1", -1, "1"));
                add(new MovementDetails("2", -2, "2"));
            }
        },
                new ArrayList<MovementDetails>() {
            {
                add(new MovementDetails("1", -1, "1"));
                add(new MovementDetails("2", -2, "2"));
            }
        },
                 "1");

        AccountDetails andreas = new AccountDetails("Nordea", "Andreas", "1122", 8888, new ArrayList<>(), new ArrayList<>(), "2");

        dummyAccounts.put("1", stanislav);
        dummyAccounts.put("2", andreas);
        
    }

    @Override
    public AccountDetails getAccount(AccountIdentifier id) throws NotFoundException {
        return dummyAccounts.get(id.getId());
    }

    @Override
    public void transfer(long amount, AccountIdentifier source, AccountIdentifier target) throws NotFoundException {
        
    }

    @Override
    public void transfer(long amount, String sourceAccNumber, String targetAccNumber) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getBalance(AccountIdentifier id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MovementDetails> getWithdrawals(AccountIdentifier id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MovementDetails> getDeposits(AccountIdentifier id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MovementDetails deposit(long amount, AccountIdentifier id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MovementDetails withdraw(long amount, AccountIdentifier id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
