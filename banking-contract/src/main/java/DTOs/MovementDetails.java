package DTOs;

import DTOs.identifiers.MovementIdentifier;

/**
 * DTO object
 *
 * @param <T>
 */
public abstract class MovementDetails<T> extends MovementIdentifier implements JSONDTO<T> {

    private String time;
    private long amount;

    public MovementDetails(String id) {
        super(id);
    }

}
