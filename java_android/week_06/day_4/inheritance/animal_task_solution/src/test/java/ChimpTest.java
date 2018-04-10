import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChimpTest {

    Chimpanzee chimp;

    @Before
    public void before(){
        chimp = new Chimpanzee();
    }
    @Test
    public void canEat(){
        assertEquals("Mmmmm!", chimp.eat());
    }

    @Test
    public void canBreathe(){
        assertEquals("Huff, puff", chimp.breathe());
    }

    @Test
    public void canWalk(){
        assertEquals("Got to get that fitbit goal!", chimp.walk());
    }

    @Test
    public void canTalk(){
        assertEquals("Monkey see, monkey do", chimp.talk());
    }


}
