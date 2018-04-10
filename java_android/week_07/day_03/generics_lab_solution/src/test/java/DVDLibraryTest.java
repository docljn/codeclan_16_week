import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DVDLibraryTest {
    Library<DVD> library;
    DVD dvd;


    @Before
    public void before() {
        library = new Library<>();
        dvd = new DVD("The Blues Brothers", Genre.COMEDY);
    }

    @Test
    public void libraryStartsEmpty() {
        assertEquals(0, library.itemCount());
    }

    @Test
    public void canAddDVDToLibrary() {
        library.addItem(dvd);
        assertEquals(1, library.itemCount());
    }

}
