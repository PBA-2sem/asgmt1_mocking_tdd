package com.teamwingitt.banking.contract;

import java.time.LocalDateTime;

/**
 * This is an interface for Movement.
 *
 */
public interface IMovementManager {

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
