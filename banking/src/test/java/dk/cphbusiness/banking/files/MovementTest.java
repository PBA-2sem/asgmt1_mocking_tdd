package dk.cphbusiness.banking.files;

import dk.cphbusiness.banking.files.dummy.MovementDummy;
import java.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
public class MovementTest {

    Movement instance;

    public MovementTest() {
        instance = new MovementDummy(1000);
    }

    @Test
    public void testGetTime() {
        System.out.println("getTime");
        LocalDateTime expResult = LocalDateTime.now();
        LocalDateTime result = instance.getTime();
        assertEquals(expResult.toString().substring(0, 10), result.toString().substring(0, 10)); // TODO change me 
    }

    @Test
    public void testGetAmount() {
        System.out.println("testGetAmount");
        long expResult = 1000;
        long result = instance.getAmount();
        assertEquals(expResult, result);
    }



}
