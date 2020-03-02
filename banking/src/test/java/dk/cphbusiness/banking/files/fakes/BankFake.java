package dk.cphbusiness.banking.files.fakes;

import dk.cphbusiness.banking.files.Account;
import dk.cphbusiness.banking.files.Bank;
import dk.cphbusiness.banking.files.Customer;
import java.util.Map;

/**
 *
 * @author awha8
 */
    public class BankFake implements Bank {

        private String cvr;
        private String name;
        private Map<String, Account> accounts;

        public BankFake(String cvr, String name, Map<String, Account> accounts) {
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
