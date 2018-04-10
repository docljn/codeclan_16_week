import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookLibraryTest {
    Library<Book> library;
    Book book;
    //DVD dvd;


    @Before
    public void before() {
        library = new Library<>();
        book = new Book("Java in a Nutshell", "David Flanagan");
        //dvd = new DVD("The Blues Brothers", Genre.COMEDY);
    }

    @Test
    public void libraryStartsEmpty() {
        assertEquals(0, library.itemCount());
    }

    @Test
    public void canAddBookToLibrary() {
        library.addItem(book);
        //library.addItem(dvd);
        assertEquals(1, library.itemCount());
    }

}
