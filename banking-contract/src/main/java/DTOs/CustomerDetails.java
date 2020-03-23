package DTOs;

import DTOs.identifiers.CustomerIdentifier;

/**
 * DTO object
 *
 * @param <T>
 */
public abstract class CustomerDetails<T> extends CustomerIdentifier implements JSONDTO<T> {
    private String cpr;
    private String name;
    private String bank;
    
    public CustomerDetails(String id) {
        super(id);
    }

}
