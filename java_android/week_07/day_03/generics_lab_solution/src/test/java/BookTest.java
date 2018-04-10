import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    Book book;

    @Before
    public void before() {
        book = new Book("Head First Java", "Sierra & Bates");
    }

    @Test
    public void hasTitle() {
        assertEquals("Head First Java", book.getTitle());
    }

    @Test
    public void hasAuthor() {
        assertEquals("Sierra & Bates", book.getAuthor());
    }
}


