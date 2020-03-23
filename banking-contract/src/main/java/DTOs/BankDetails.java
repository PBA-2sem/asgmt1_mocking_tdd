package DTOs;

import DTOs.identifiers.BankIdentifier;

/**
 * DTO object
 *
 * @param <T>
 */
public abstract class BankDetails<T> extends BankIdentifier implements JSONDTO<T> {

    private String name;
    private String cvr;

    public BankDetails(String id) {
        super(id);
    }

}
