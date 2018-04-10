import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RoomTest {
    Room room;
    Guest guest1;
    Guest guest2;
    Guest guest3;

    @Before
    public void before() {
        room = new Room( 2);
        guest1 = new Guest("Ada Lovelace");
        guest2 = new Guest("Alan Turing");
        guest3 = new Guest("Clive Sinclair");
    }

    @Test
    public void hasCapacity() {
        assertEquals(2, room.getCapacity());
    }

    @Test
    public void roomStartsEmpty() {
        assertEquals(0, room.numberOfGuests());
        assertEquals(true, room.isVacant());
    }

    @Test
    public void canCheckInGuest() {
        room.checkIn(guest1);
        assertEquals(1, room.numberOfGuests());
        assertEquals(false, room.isVacant());
    }

    @Test
    public void canCheckoutGuest() {
        room.checkIn(guest1);
        room.checkOut();
        assertEquals(true, room.isVacant());
        assertEquals(0, room.numberOfGuests());
    }

    @Test
    public void canBeFull() {
        room.checkIn(guest1);
        room.checkIn(guest2);
        assertEquals(true, room.isFull());
    }

    @Test
    public void cannotCheckInGuestIfRoomFull() {
        room.checkIn(guest1);
        room.checkIn(guest2);
        room.checkIn(guest3);

        assertEquals(false, room.isVacant());
        assertEquals(2, room.numberOfGuests());
    }

    @Test
    public void canGetGuestsCheckedIntoRoom() {
        room.checkIn(guest1);
        ArrayList<Guest> guests = room.getGuests();
        assertEquals(1, guests.size());
        assertEquals("Ada Lovelace", guests.get(0).getName());
    }

    @Test
    public void canCheckInMultipleGuests() {
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        guestList.add(guest2);
        room.checkInGuests(guestList);
        assertEquals(false, room.isVacant());
        assertEquals(2, room.numberOfGuests());
    }

    @Test
    public void cannotCheckInMoreGuestsThanRoomHolds() {
        ArrayList<Guest> guestList = new ArrayList<Guest>();
        guestList.add(guest1);
        guestList.add(guest2);
        guestList.add(guest3);
        room.checkInGuests(guestList);
        assertEquals(true, room.isVacant());
        assertEquals(0, room.numberOfGuests());
    }
}
