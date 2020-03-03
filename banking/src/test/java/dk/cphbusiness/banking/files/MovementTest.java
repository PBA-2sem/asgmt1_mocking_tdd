package dk.cphbusiness.banking.files;

import dk.cphbusiness.banking.files.fakes.MovementFake;
import dk.cphbusiness.banking.files.stub.TimeStub;
import java.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for MovementFake class
 *
 */
public class MovementTest {

    Movement instance;

    public MovementTest() {
        instance = new MovementFake(1000);
    }

    @Test
    public void testGetTime() {
        System.out.println("getTime");
        LocalDateTime expResult = TimeStub.getFixedTime();
        LocalDateTime result = instance.getTime();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAmount() {
        System.out.println("testGetAmount");
        long expResult = 1000;
        long result = instance.getAmount();
        assertEquals(expResult, result);
    }

}
