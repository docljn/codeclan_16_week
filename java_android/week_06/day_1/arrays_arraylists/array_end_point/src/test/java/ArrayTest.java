import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayTest {

    ArrayExample arrayExample;

    @Before
    public void before(){
        arrayExample = new ArrayExample();
    }

    @Test
    public void addItem(){
        arrayExample.add("Hello");
        assertEquals(1, arrayExample.getWordCount());
    }
}
