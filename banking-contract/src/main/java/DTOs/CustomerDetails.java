package DTOs;

import DTOs.identifiers.CustomerIdentifier;

/**
 * DTO object
 *
 */
public class CustomerDetails extends CustomerIdentifier {

    private String cpr;
    private String name;
    private String bank;

    public CustomerDetails(String cpr, String name, String bank, String id) {
        super(id);
        this.cpr = cpr;
        this.name = name;
        this.bank = bank;
    }

    public String getCpr() {
        return cpr;
    }

    public String getName() {
        return name;
    }

    public String getBank() {
        return bank;
    }

}
