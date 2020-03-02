package dk.cphbusiness.banking.files.dummy;

import dk.cphbusiness.banking.files.Movement;
import java.time.LocalDateTime;

/**
 *
 * @author awha8
 */
    public class MovementDummy implements Movement {

        private LocalDateTime time;
        private long amount;

        public MovementDummy(long amount) {

            this.time = LocalDateTime.now();
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
