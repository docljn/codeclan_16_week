import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    Book book;

    @Before
    public void before(){
        book = new Book("Colour of Magic", "Terry Pratchett", Genre.FANTASY);
    }

    @Test
    public void hasTitle(){
        assertEquals("Colour of Magic", book.getTitle());
    }

    @Test
    public void hasAuthor(){
        assertEquals("Terry Pratchett", book.getAuthor());
    }

    @Test
    public void hasGenre(){
        assertEquals(Genre.FANTASY, book.getGenre());
    }

    @Test
    public void hasGenreDescription(){
        assertEquals("Idea with no basis in reality.", book.getGenreDescription());
    }
}
