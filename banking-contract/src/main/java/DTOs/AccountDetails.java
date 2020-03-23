package DTOs;

import DTOs.identifiers.AccountIdentifier;
import java.util.List;

/**
 * DTO object
 *
 * @param <T>
 */
public abstract class AccountDetails<T> extends AccountIdentifier implements JSONDTO<T> {

    private String bank;
    private String customer;
    private String number;
    private long balance;
    private List<MovementDetails> withdrawals;
    private List<MovementDetails> deposits;

    public AccountDetails(String id) {
        super(id);
    }

}
