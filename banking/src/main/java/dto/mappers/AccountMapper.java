package dto.mappers;

import DTOs.AccountDetails;
import DTOs.MovementDetails;
import dk.cphbusiness.banking.interfaces.Account;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeff
 */
public class AccountMapper implements Mapper<Account, AccountDetails> {

    @Override
    public AccountDetails fromInternal(Account object) {
        MovementMapper mm = new MovementMapper();

        // Map movements
        List<MovementDetails> withdrawals = new ArrayList<>();
        object.getWithdrawals().forEach((w) -> withdrawals.add(mm.fromInternal(w)));

        List<MovementDetails> deposits = new ArrayList<>();
        object.getDeposits().forEach((d) -> deposits.add(mm.fromInternal(d)));

        return new AccountDetails(
                object.getBank().getName(),
                object.getCustomer().getName(),
                object.getNumber(),
                object.getBalance(),
                withdrawals,
                deposits,
                object.getNumber());
    }

    @Override
    public Account toInternal(AccountDetails object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
