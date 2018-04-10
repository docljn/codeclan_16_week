import People.Adult;
import People.Child;
import People.Student;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    Adult adult;
    Child child;
    Student student;

    @Before
    public void setup(){
        adult = new Adult("Ruth", 20, 158);
        child = new Child("Alba", 0, 110);
        student = new Student("Colin", 10, 170);
    }

    @Test
    public void peopleHaveNames(){
        assertEquals("Ruth", adult.getName());
        assertEquals("Alba", child.getName());
        assertEquals("Colin", student.getName());
    }

    @Test
    public void peopleHaveHeights(){
        assertEquals(158, adult.getHeight(), 0);
        assertEquals(110, child.getHeight(), 0);
        assertEquals(170, student.getHeight(), 0);
    }

    @Test
    public void peopleHaveFunds(){
        assertEquals(20, adult.getFunds(), 0);
        assertEquals(0, child.getFunds(), 0);
        assertEquals(10, student.getFunds(), 0);
    }

    @Test
    public void childFavouriteRide(){;
        assertEquals("I wanna go on the dodgems!", child.favouriteRide("dodgems"));
    }

    @Test
    public void adultFavouriteRide(){
        assertEquals("I have too many adult responsibilities! I'm not sure I can afford to go on the dodgems...", adult.favouriteRide("the dodgems"));
    }

    @Test
    public void studentFavouriteRide(){
        assertEquals("Can I use my student discount on the dodgems?", student.favouriteRide("the dodgems"));
    }

}
