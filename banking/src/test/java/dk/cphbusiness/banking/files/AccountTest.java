package dk.cphbusiness.banking.files;

import dk.cphbusiness.banking.files.MovementTest.MovementImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class AccountTest {

    public AccountTest() {
    }

    public static class AccountImpl implements Account {

        private Bank bank;
        private Customer customer;
        private String number;
        private long balance = 0;
        private List<Movement> withdrawals;
        private List<Movement> deposits;

        public AccountImpl(Bank bank, Customer customer, String number) {
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

            // create deposit movement TODO
            Movement movement_deposit = new MovementImpl(amount);
            target.getDeposits().add(movement_deposit);

            // create withdrawal movement
            Movement movement_withdrawal = new MovementImpl(amount);
            withdrawals.add(movement_withdrawal);

        }

        @Override
        public void transfer(long amount, String targetNumber) {
            Account target = bank.getAccount(targetNumber);
            transfer(amount, target);
        }

        @Override
        public long getBalance() {
            return balance;
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
    }
}
