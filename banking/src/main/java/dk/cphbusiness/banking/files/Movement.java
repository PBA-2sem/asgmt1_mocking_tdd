package dk.cphbusiness.banking.files;

import java.time.LocalDateTime;

public interface Movement {
    LocalDateTime getTime();
    long getAmount();
}