package dk.cphbusiness.banking.files.stub;

import java.time.*;

/**
 * This is a Stub to be used for testing of various getTime methods.
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 * Code borrowed from
 * https://www.geeksforgeeks.org/java-8-clock-fixed-method-with-examples/
 */
public class TimeStub {

    /**
     * This method will be used for returning a fixed/static timestamp.
     *
     * @return LocalDateTime
     */
    public static LocalDateTime getFixedTime() {
        Instant instant = Instant.parse("2020-03-02T12:00:00.00Z");
        ZoneId zoneId = ZoneId.of("Europe/Paris"); //https://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html#SHORT_IDS
        Clock clock = Clock.fixed(instant, zoneId);
        LocalDateTime dateAndTime = LocalDateTime.now(clock); //http://www.java2s.com/Tutorials/Java/Data_Type_How_to/Date_Time/Create_Local_date_time_from_Clock.htm
        return dateAndTime;
    }

}
