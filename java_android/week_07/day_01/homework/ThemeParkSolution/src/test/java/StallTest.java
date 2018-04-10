import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StallTest {

    Stall hotdogs;

    @Before
    public void setup(){
        hotdogs = new Stall("Hotdogs", 11);
    }

    @Test
    public void hasProduct(){
        assertEquals("Hotdogs", hotdogs.getProduct());
    }

    @Test
    public void canCalculateFunFactor(){
        assertEquals(11, hotdogs.calculateFunFactor());
    }
}
