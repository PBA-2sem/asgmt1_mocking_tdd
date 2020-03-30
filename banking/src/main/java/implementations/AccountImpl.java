package implementations;

import dk.cphbusiness.banking.interfaces.Account;
import dk.cphbusiness.banking.interfaces.Bank;
import dk.cphbusiness.banking.interfaces.Customer;
import dk.cphbusiness.banking.interfaces.Movement;
import exceptions.NotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author awha8
 */
public class AccountImpl implements Account {

    private final Bank bank;
    private final Customer customer;
    private final String number;
    private long balance = 0;
    private final List<Movement> withdrawals;
    private final List<Movement> deposits;

    public AccountImpl(Bank bank, Customer customer, String number) {
        this.bank = bank;
        this.customer = customer;
        this.number = number;
        this.withdrawals = new ArrayList<>();
        this.deposits = new ArrayList<>();
    }

    @Override
    public void transfer(long amount, Account target) throws NotFoundException {
        if (target == null) {
            throw new NotFoundException("Account: does not exist!");
        }

        this.withdraw(amount);
        target.deposit(amount);
    }

    @Override
    public void transfer(long amount, String targetNumber) throws NotFoundException {
        Account target = bank.getAccount(targetNumber);
        if (target == null) {
            throw new NotFoundException("Account: " + targetNumber + " does not exist");
        }
        transfer(amount, target);
    }

    @Override
    public Bank getBank() {
        return bank;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public List<Movement> getWithdrawals() {
        return withdrawals;

    }

    @Override
    public List<Movement> getDeposits() {
        return deposits;
    }

    @Override
    public long getBalance() {
        return balance;
    }

    @Override
    public Movement deposit(long amount) {
          
      Movement movement = new MovementImpl(amount);
      this.deposits.add(movement);
      balance += amount;
      return movement;
        }

    @Override
    public Movement withdraw(long amount) {
        Movement movement = new MovementImpl(-amount);
        this.withdrawals.add(movement);
        balance += -amount;
        return movement;
    }
}
