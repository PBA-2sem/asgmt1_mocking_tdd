package dk.cphbusiness.banking.contractTests;

import DTOs.AccountDetails;
import DTOs.MovementDetails;
import DTOs.identifiers.AccountIdentifier;
import com.teamwingitt.banking.contract.IAccountManager;
import dk.cphbusiness.banking.interfaces.Account;
import dto.mappers.AccountMapper;
import exceptions.NotFoundException;
import implementations.AccountImpl;
import implementations.BankImpl;
import implementations.CustomerImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountManagerDummy implements IAccountManager {

    BankImpl bank;
    CustomerImpl jeff;
    CustomerImpl mathias;
    AccountImpl accJeff;
    AccountImpl accMathias;
    AccountMapper accMapper;

    public AccountManagerDummy() {

        accMapper = new AccountMapper();
        bank = new BankImpl("1", "DanskeBank", new HashMap<>());
        jeff = new CustomerImpl("1", "Jeff", bank);
        mathias = new CustomerImpl("2", "Mathias", bank);
        accJeff = new AccountImpl(bank, jeff, "1");
        accJeff.deposit(20);
        accMathias = new AccountImpl(bank, mathias, "2");
        accMathias.deposit(20);
        bank.addAccount(accJeff);
        bank.addAccount(accMathias);

        //        AccountDetails stanislav = new AccountDetails("DanskeBank", "Stanislav", "1234", 1000,
        //                new ArrayList<MovementDetails>() {
        //            {
        //                add(new MovementDetails("12/05/1996", 1000, "1"));
        //                add(new MovementDetails("12/05/1998", 2000, "2"));
        //            }
        //        },
        //                new ArrayList<MovementDetails>() {
        //            {
        //                add(new MovementDetails("12/05/2000", 3000, "3"));
        //                add(new MovementDetails("12/05/2002", 4000, "4"));
        //            }
        //        },
        //                "1");
        //
        //        AccountDetails mathias = new AccountDetails("MINEGENBANK", "Mathias", "1234", 500,
        //                new ArrayList<MovementDetails>() {
        //            {
        //                add(new MovementDetails("12/05/1996", 1000, "10"));
        //                add(new MovementDetails("12/05/1998", 2000, "11"));
        //            }
        //        },
        //                new ArrayList<MovementDetails>() {
        //            {
        //                add(new MovementDetails("12/05/2000", 3000, "12"));
        //                add(new MovementDetails("12/05/2002", 4000, "13"));
        //            }
        //        },
        //                "2");
        //
        //        AccountDetails andreas = new AccountDetails("Nordea", "Andreas", "5555", 1001, new ArrayList<>(), new ArrayList<>(), "3");
        //        AccountDetails kimjungun = new AccountDetails("Himself", "Kimjungun", "6666", 1000000, new ArrayList<>(), new ArrayList<>(), "4");
        //        AccountDetails donaldtrump = new AccountDetails("Himself", "DONALDTRUMP", "3000", 10, new ArrayList<>(), new ArrayList<>(), "5");
        //        AccountDetails erdogan = new AccountDetails("NoOneKnows", "ERDOGAN", "4000", 10, new ArrayList<>(), new ArrayList<>(), "6");
        //        AccountDetails dumbledore = new AccountDetails("NoOneKnows", "ERDOGAN", "1122", 100, new ArrayList<>(), new ArrayList<>(), "7");
        //        AccountDetails voldemort = new AccountDetails("NoOneKnows", "ERDOGAN", "2211", 100, new ArrayList<>(), new ArrayList<>(), "8");
        //
        //        dummyAccounts.put("1", stanislav);
        //        dummyAccounts.put("2", mathias);
        //        dummyAccounts.put("3", andreas);
        //        dummyAccounts.put("4", kimjungun);
        //        dummyAccounts.put("5", donaldtrump);
        //        dummyAccounts.put("6", erdogan);
        //        dummyAccounts.put("7", dumbledore);
        //        dummyAccounts.put("8", voldemort);
    }

    @Override
    public AccountDetails getAccount(AccountIdentifier id) throws NotFoundException {
        Account acc = this.bank.getAccount(id.getId());
        return accMapper.fromInternal(acc);
    }

    @Override
    public void transfer(long amount, AccountIdentifier source, AccountIdentifier target) throws NotFoundException {
        Account sourceAcc = this.bank.getAccount(source.getId());
        Account targetAcc = this.bank.getAccount(target.getId());
        sourceAcc.transfer(amount, targetAcc);
    }

    @Override
    public void transfer(long amount, String sourceAccNumber, String targetAccNumber) throws NotFoundException {
        Account sourceAcc = this.bank.getAccount(sourceAccNumber);
        sourceAcc.transfer(amount, targetAccNumber);
    }

    @Override
    public long getBalance(AccountIdentifier id) throws NotFoundException {
        Account sourceAcc = this.bank.getAccount(id.getId());
        return sourceAcc.getBalance();
    }

    @Override
    public List<MovementDetails> getWithdrawals(AccountIdentifier id) throws NotFoundException {
        Account sourceAcc = this.bank.getAccount(id.getId());
        return accMapper.fromInternal(sourceAcc).getWithdrawals();
    }

    @Override
    public List<MovementDetails> getDeposits(AccountIdentifier id) throws NotFoundException {
        Account sourceAcc = this.bank.getAccount(id.getId());
        return accMapper.fromInternal(sourceAcc).getDeposits();
    }

    @Override
    public MovementDetails deposit(long amount, AccountIdentifier id) throws NotFoundException {
//        dummyAccounts.get(id.getId()).setBalance(amount);
//        MovementDetails md = new MovementDetails("20/04/2020", amount, "5");
//        dummyAccounts.get(id.getId()).getWithdrawals().add(md);
//        return md;
        return null;
    }

    @Override
    public MovementDetails withdraw(long amount, AccountIdentifier id) throws NotFoundException {
//        dummyAccounts.get(id.getId()).setBalance(-amount);
//        MovementDetails md = new MovementDetails("20/04/2020", -amount, "5");
//        dummyAccounts.get(id.getId()).getWithdrawals().add(md);
//        return md;
        return null;
    }

}
