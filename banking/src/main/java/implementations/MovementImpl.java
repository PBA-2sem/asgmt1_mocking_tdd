package implementations;

import dk.cphbusiness.banking.interfaces.Movement;
import java.time.LocalDateTime;

/**
 *
 * @author stanislavnovitski
 */
public class MovementImpl implements Movement {

    private LocalDateTime time;
    private long amount;

    public MovementImpl(long amount) {
        this.time = LocalDateTime.now();
        this.amount = amount;
    }

    public MovementImpl(long amount, LocalDateTime time) {
        this.time = time;
        this.amount = amount;
    }

    @Override
    public LocalDateTime getTime() {
        return this.time;
    }

    @Override
    public long getAmount() {
        return this.amount;
    }

}
