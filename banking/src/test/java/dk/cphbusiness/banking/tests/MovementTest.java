package dk.cphbusiness.banking.tests;

import dk.cphbusiness.banking.interfaces.Movement;
import dk.cphbusiness.banking.files.fakes.MovementFake;
import dk.cphbusiness.banking.files.stub.TimeStub;
import implementations.MovementImpl;
import java.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for MovementFake class
 *
 */
public class MovementTest {

    @Test
    public void testGetTime() {
        Movement instance = new MovementFake(1000);
        System.out.println("getTime");
        LocalDateTime expResult = TimeStub.getFixedTime();
        LocalDateTime result = instance.getTime();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAmount() {
        Movement instance = new MovementImpl(1000);
        System.out.println("getAmount");
        long expResult = 1000;
        long result = instance.getAmount();
        assertEquals(expResult, result);
    }

}
