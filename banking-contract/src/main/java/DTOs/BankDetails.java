package DTOs;

import DTOs.identifiers.BankIdentifier;

/**
 * DTO object
 *
 */
public class BankDetails extends BankIdentifier {

    private String name;
    private String cvr;

    public BankDetails(String name, String cvr, String id) {
        super(id);
        this.name = name;
        this.cvr = cvr;
    }

    public String getName() {
        return name;
    }

    public String getCvr() {
        return cvr;
    }

}
