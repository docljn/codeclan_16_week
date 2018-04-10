import People.Adult;
import People.Child;
import People.Student;
import Rides.Dodgems;
import Rides.Waltzer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RideTest {

    Waltzer waltzer;
    Dodgems dodgems;
    Adult adult;
    Student student;
    Child child;
    Child child2;

    @Before
    public void setup(){
        waltzer = new Waltzer(2, 15, 160, 10);
        dodgems = new Dodgems(3, 5, 100, 5);
        adult = new Adult("Ruth", 20, 158);
        student = new Student("Colin", 10, 170);
        child = new Child("Alba", 5, 110);
        child2 = new Child("Zsolt", 20, 180);
    }

    @Test
    public void ridesHaveCapacity(){
        assertEquals(2, waltzer.getCapacity());
        assertEquals(3, dodgems.getCapacity());
    }

    @Test
    public void ridesHaveMinHeights(){
        assertEquals(160, waltzer.getMinHeight(), 0);
        assertEquals(100, dodgems.getMinHeight(), 0);
    }

    @Test
    public void ridesHavePrices(){
        assertEquals(15, waltzer.getPrice(),0);
        assertEquals(5, dodgems.getPrice(), 0);
    }

    @Test
    public void queuesStartEmpty(){
        assertEquals(0, waltzer.queueSize());
    }

    @Test
    public void queuesCanAddCustomer(){
        waltzer.addToQueue(child2);
        assertEquals(1, waltzer.queueSize());
    }

    @Test
    public void queueingReducesMoney(){
        dodgems.addToQueue(child);
        assertEquals(1, dodgems.queueSize());
        assertEquals(0, child.getFunds(), 0);
    }

    @Test
    public void customersCantAffordRides(){
        waltzer.addToQueue(student);
        assertEquals(0, waltzer.queueSize());
    }

    @Test
    public void customersCantMeetMinHeight(){
        waltzer.addToQueue(child);
        assertEquals(0, waltzer.queueSize());
    }

    @Test
    public void queueCanBoardRideToCapacity(){
        dodgems.addToQueue(adult);
        dodgems.addToQueue(child);
        dodgems.addToQueue(student);
        dodgems.addToQueue(child2);
        assertEquals(4, dodgems.queueSize());
        dodgems.board();
        assertEquals(1, dodgems.queueSize());
    }

    @Test
    public void ridesCanGo(){
        assertEquals("SOUND OF PEOPLE BUMPING CARS FOR AMUSEMENT", dodgems.go());
        assertEquals("Scream if you wanna go faster!", waltzer.go());
    }

    @Test
    public void canCalculateFunFactors(){
        assertEquals(5, waltzer.calculateFunFactor());
        assertEquals(15, dodgems.calculateFunFactor());
    }


}
