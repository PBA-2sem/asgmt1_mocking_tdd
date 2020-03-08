package dk.cphbusiness.banking.files;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author stanislavnovitski
 */


public class MBTest {

    @Test
    public void testNameMkyong() {

        MessageBuilder obj = new MessageBuilder();
        assertEquals("Hello mkyong", obj.getMessage("mkyong"));

    }
}
