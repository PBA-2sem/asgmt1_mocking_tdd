package DTOs;

import DTOs.identifiers.MovementIdentifier;

/**
 *
 * @author stanislavnovitski
 */
public abstract class MovementDetails<T> extends MovementIdentifier implements JSONDTO<T> {

    private String time;
    private long amount;

    public MovementDetails(String id) {
        super(id);
    }

}
