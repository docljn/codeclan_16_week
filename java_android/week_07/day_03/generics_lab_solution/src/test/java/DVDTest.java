import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DVDTest {
    DVD dvd;

    @Before
    public void before() {
        dvd = new DVD("The Blues Brothers", Genre.COMEDY);

    }

    @Test
    public void hasTitle() {
        assertEquals("The Blues Brothers", dvd.getTitle());
    }

    @Test
    public void hasGenre() {
        assertEquals(Genre.COMEDY, dvd.getGenre());
    }
}
