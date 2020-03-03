package dk.cphbusiness.banking.files.fakes;

import dk.cphbusiness.banking.files.Account;
import dk.cphbusiness.banking.files.Bank;
import dk.cphbusiness.banking.files.Customer;
import dk.cphbusiness.banking.files.Movement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author awha8
 */
public class AccountFake implements Account {

    private final Bank bank;
    private final Customer customer;
    private final String number;
    private long balance = 0;
    private final List<Movement> withdrawals;
    private final List<Movement> deposits;

    public AccountFake(Bank bank, Customer customer, String number) {
        this.bank = bank;
        this.customer = customer;
        this.number = number;
        this.withdrawals = new ArrayList<>();
        this.deposits = new ArrayList<>();
    }

    @Override
    public void transfer(long amount, Account target) {
        balance -= amount;
        target.setBalance(amount);

        // create deposit movement
        Movement movementDeposit = new MovementFake(amount);
        target.getDeposits().add(movementDeposit);

        // create withdrawal movement
        Movement movementWithdrawal = new MovementFake(-amount);
        withdrawals.add(movementWithdrawal);

    }

    @Override
    public void transfer(long amount, String targetNumber) {
        Account target = bank.getAccount(targetNumber);
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
    public void setBalance(long amount) {
        balance = amount;
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
}
