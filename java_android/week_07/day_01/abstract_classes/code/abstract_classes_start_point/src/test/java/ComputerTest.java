import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComputerTest {
    DesktopComputer desktop;

    @Before
    public void before() {
        desktop = new DesktopComputer();
    }

    @Test
    public void desktopCanRunApplication(){
        assertEquals("I am running IntelliJ", desktop.runApplication("IntelliJ"));
    }
}
