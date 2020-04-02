package implementations.db;

import DTOs.AccountDetails;
import DTOs.MovementDetails;
import DTOs.identifiers.AccountIdentifier;
import com.teamwingitt.banking.contract.IAccountManager;
import dao.AccountDAO;
import dao.MovementDAO;
import dk.cphbusiness.banking.interfaces.Account;
import dk.cphbusiness.banking.interfaces.Movement;
import dto.mappers.AccountMapper;
import dto.mappers.MovementMapper;
import exceptions.NotFoundException;
import implementations.AccountImpl;
import implementations.MovementImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stanislavnovitski
 */
public class AccountManager implements IAccountManager {

    MovementDAO movementDAO;
    AccountDAO accountDAO;
    AccountMapper accountMapper;
    MovementMapper movementMapper;

    public AccountManager() {
        movementDAO = new MovementDAO();
        accountDAO = new AccountDAO();
        accountMapper = new AccountMapper();
        movementMapper = new MovementMapper();
    }

    @Override
    public AccountDetails getAccount(AccountIdentifier id) throws NotFoundException {
        AccountImpl acc = (AccountImpl) accountDAO.read(id.getId());
        List<Movement> withdrawals = movementDAO.getAllWithdrawalsForAccount(id.getId());
        List<Movement> deposits = movementDAO.getAllDepositsForAccount(id.getId());
        acc.addWithdrawals(withdrawals);
        acc.addDeposits(deposits);
        return accountMapper.fromInternal(acc);
    }

    @Override
    public void transfer(long amount, AccountIdentifier source, AccountIdentifier target) throws NotFoundException {

        movementDAO.addMovement(-amount, source.getId(), target.getId(), "withdrawal");
        movementDAO.addMovement(amount, target.getId(), source.getId(), "deposit");

        AccountImpl accSource = (AccountImpl) accountDAO.read(source.getId());
        AccountImpl accTarget = (AccountImpl) accountDAO.read(target.getId());
        
        accountDAO.updateBalanceForAccount(target.getId(), accTarget.getBalance() + amount);
        accountDAO.updateBalanceForAccount(source.getId(), accSource.getBalance() - amount);
    }

    @Override
    public void transfer(long amount, String sourceAccNumber, String targetAccNumber) throws NotFoundException {

        movementDAO.addMovement(-amount, sourceAccNumber, targetAccNumber, "withdrawal");
        movementDAO.addMovement(amount, targetAccNumber, sourceAccNumber, "deposit");
        
        AccountImpl accSource = (AccountImpl) accountDAO.read(sourceAccNumber);
        AccountImpl accTarget = (AccountImpl) accountDAO.read(targetAccNumber);

        accountDAO.updateBalanceForAccount(targetAccNumber, accTarget.getBalance() + amount);
        accountDAO.updateBalanceForAccount(sourceAccNumber, accSource.getBalance() - amount);
    }

    @Override
    public long getBalance(AccountIdentifier id) throws NotFoundException {
        Account acc = (AccountImpl) accountDAO.read(id.getId());
        return acc.getBalance();
    }

    @Override
    public List<MovementDetails> getWithdrawals(AccountIdentifier id) throws NotFoundException {
        List<Movement> withdrawalsInternal = movementDAO.getAllWithdrawalsForAccount(id.getId());
        List<MovementDetails> withdrawals = new ArrayList<>();

        withdrawalsInternal.forEach((w) -> withdrawals.add(movementMapper.fromInternal(w)));

        return withdrawals;
    }

    @Override
    public List<MovementDetails> getDeposits(AccountIdentifier id) throws NotFoundException {
        List<Movement> depositsInternal = movementDAO.getAllDepositsForAccount(id.getId());
        List<MovementDetails> deposits = new ArrayList<>();

        depositsInternal.forEach((w) -> deposits.add(movementMapper.fromInternal(w)));

        return deposits;

    }

    @Override
    public MovementDetails deposit(long amount, AccountIdentifier id) throws NotFoundException {
        AccountImpl acc = (AccountImpl) accountDAO.read(id.getId());
        
        MovementImpl movement = movementDAO.addMovement(amount, null, id.getId(), "deposit");
        
        accountDAO.updateBalanceForAccount(id.getId(), acc.getBalance() + amount);
        
        return movementMapper.fromInternal(movement);
    }

    @Override
    public MovementDetails withdraw(long amount, AccountIdentifier id) throws NotFoundException {
        AccountImpl acc = (AccountImpl) accountDAO.read(id.getId());
        MovementImpl movement = movementDAO.addMovement(-amount, id.getId(), null, "withdrawal");
        accountDAO.updateBalanceForAccount(id.getId(), acc.getBalance() - amount);
        return movementMapper.fromInternal(movement);
    }

}
