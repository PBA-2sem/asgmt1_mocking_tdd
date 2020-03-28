package DTOs;

import DTOs.identifiers.AccountIdentifier;
import java.util.List;

/**
 * DTO object
 *
 */
public class AccountDetails extends AccountIdentifier {

    private String bank;
    private String customer;
    private String number;
    private long balance;
    private List<MovementDetails> withdrawals;
    private List<MovementDetails> deposits;

    public AccountDetails(String bank, String customer, String number, long balance, List<MovementDetails> withdrawals, List<MovementDetails> deposits, String id) {
        super(id);
        this.bank = bank;
        this.customer = customer;
        this.number = number;
        this.balance = balance;
        this.withdrawals = withdrawals;
        this.deposits = deposits;
    }

    public String getBank() {
        return bank;
    }

    public String getCustomer() {
        return customer;
    }

    public String getNumber() {
        return number;
    }

    public long getBalance() {
        return balance;
    }

    public List<MovementDetails> getWithdrawals() {
        return withdrawals;
    }

    public List<MovementDetails> getDeposits() {
        return deposits;
    }

}
