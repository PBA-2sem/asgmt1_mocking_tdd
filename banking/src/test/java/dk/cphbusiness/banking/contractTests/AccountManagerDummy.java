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

    List<MovementDetails> dummyWithdrawals = new ArrayList<MovementDetails>() {
        {
            add(new MovementDetails("1", -1, "1"));
            add(new MovementDetails("2", -2, "2"));
            add(new MovementDetails("3", -3, "3"));
        }
    };

    List<MovementDetails> dummyDeposits = new ArrayList<MovementDetails>() {
        {
            add(new MovementDetails("4", 4, "4"));
            add(new MovementDetails("5", 5, "5"));
            add(new MovementDetails("6", 6, "6"));
        }
    };

    AccountDetails stanislav = new AccountDetails("DanskeBank", "Stanislav", "1234", 1337, dummyWithdrawals, dummyDeposits, "1");
    

    public AccountManagerDummy() {

        dummyAccounts.put("1", stanislav);
    }

    @Override
    public AccountDetails getAccount(AccountIdentifier id) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transfer(long amount, AccountIdentifier source, AccountIdentifier target) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
