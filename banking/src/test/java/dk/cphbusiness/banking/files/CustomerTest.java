package dk.cphbusiness.banking.files;

import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class CustomerTest {

    public CustomerTest() {
    }

    public class CustomerImpl implements Customer {

        private String cpr;
        private String name;
        private Bank bank;

        public CustomerImpl(String cpr, String name, Bank bank) {
            this.cpr = cpr;
            this.name = name;
            this.bank = bank;
        }

        @Override
        public void transfer(int amount, Account account, Account targetAccount) {
            Account thisAccount = bank.getAccount(account.getNumber());
            thisAccount.transfer(amount, targetAccount);
        }

        @Override
        public String getCpr() {
            return cpr;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public Bank getBank() {
            return bank;
        }

        @Override
        public Map<String, Account> getAccounts() {
            return bank.getAccounts(this);
        }

        @Override
        public List<Movement> getListOfWithdrawal(int number) {
            return bank.getAccount(this.name).getWithdrawals();
        }

        @Override
        public List<Movement> getListOfDeposits(int number) {
            return bank.getAccount(this.name).getDeposits();
        }
    }

}
