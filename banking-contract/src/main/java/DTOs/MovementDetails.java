package DTOs;

import DTOs.identifiers.MovementIdentifier;

/**
 * DTO object
 *
 */
public class MovementDetails extends MovementIdentifier {

    private String time;
    private long amount;

    public MovementDetails(String time, long amount, String id) {
        super(id);
        this.time = time;
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public long getAmount() {
        return amount;
    }

}
