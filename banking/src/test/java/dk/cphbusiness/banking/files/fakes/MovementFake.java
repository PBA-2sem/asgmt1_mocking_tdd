package dk.cphbusiness.banking.files.fakes;

import dk.cphbusiness.banking.interfaces.Movement;
import dk.cphbusiness.banking.files.stub.TimeStub;
import java.time.LocalDateTime;

/**
 *
 * @author awha8
 */
public class MovementFake implements Movement {

    private final LocalDateTime time;
    private final long amount;

    public MovementFake(long amount) {

        this.time = TimeStub.getFixedTime();
        this.amount = amount;
    }

    @Override
    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public long getAmount() {
        return amount;
    }

}
