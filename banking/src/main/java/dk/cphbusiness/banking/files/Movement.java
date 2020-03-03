package dk.cphbusiness.banking.files;

import java.time.LocalDateTime;

/**
 * This is an interface for Movement.
 *
 */
public interface Movement {

    /**
     * This method will be used to get the Time of the Movement.
     *
     * @return LocalDateTime
     */
    LocalDateTime getTime();

    /**
     * This method will be used to get amount of money for the Movement.
     *
     * @return amount
     */
    long getAmount();
}
