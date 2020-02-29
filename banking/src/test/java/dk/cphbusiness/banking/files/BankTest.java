package dk.cphbusiness.banking.files;

import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class BankTest {

    public BankTest() {
    }

    public class BankImpl implements Bank {

        private String cvr;
        private String name;
        private Map<String, Account> accounts;

        public BankImpl(String cvr, String name, Map<String, Account> accounts) {
            this.cvr = cvr;
            this.name = name;
            this.accounts = accounts;
        }
        

        @Override
        public String getCvr() {
            return cvr;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public Account getAccount(String number) {
            return accounts.get(number);
        }

        @Override
        public void addAccount(Account account) {
            accounts.put(account.getNumber(), account);
        }

        @Override
        public Map<String, Account> getAccounts(Customer customer) {
            return customer.getAccounts();
        }
    }

}
