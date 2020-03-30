package dk.cphbusiness.banking.contractTests;

import DTOs.AccountDetails;
import DTOs.MovementDetails;
import DTOs.identifiers.AccountIdentifier;
import com.teamwingitt.banking.contract.IAccountManager;
import dk.cphbusiness.banking.interfaces.Account;
import dto.mappers.AccountMapper;
import dto.mappers.MovementMapper;
import exceptions.NotFoundException;
import implementations.AccountImpl;
import implementations.BankImpl;
import implementations.CustomerImpl;
import java.util.List;

public class AccountManagerDummy implements IAccountManager {

    BankImpl bank;
    CustomerImpl jeff;
    CustomerImpl mathias;
    AccountImpl accJeff;
    AccountImpl accMathias;
    AccountMapper accMapper;
    MovementMapper moveMapper;

    public AccountManagerDummy() {

        accMapper = new AccountMapper();
        moveMapper = new MovementMapper();
        bank = new BankImpl("1", "DanskeBank");
        jeff = new CustomerImpl("1", "Jeff", bank);
        mathias = new CustomerImpl("2", "Mathias", bank);
        accJeff = new AccountImpl(bank, jeff, "1");
        accJeff.deposit(20);
        accMathias = new AccountImpl(bank, mathias, "2");
        accMathias.deposit(20);
        bank.addAccount(accJeff);
        bank.addAccount(accMathias);

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
        Account acc = this.bank.getAccount(id.getId());
        return moveMapper.fromInternal(acc.deposit(amount));

    }

    @Override
    public MovementDetails withdraw(long amount, AccountIdentifier id) throws NotFoundException {
        Account acc = this.bank.getAccount(id.getId());
        return moveMapper.fromInternal(acc.withdraw(amount));

    }

}
