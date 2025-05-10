package HotelMaaikeTest;

import org.junit.jupiter.api.Test;
import week_5.HotelMaaike.Room;
import static org.junit.jupiter.api.Assertions.*;

public class HotelMaiikeRoomTest {
    @Test
    public void checkInTest(){
        Room room = new Room();
        room.checkIn();
        assertTrue(room.isDirty());
        assertTrue((room.isOccupied()));
    }
    @Test
    public void checkOutTest(){
        Room room = new Room();
        room.checkOut();
        assertFalse(room.isOccupied());
        assertFalse(room.isDirty());
    }
    @Test
    public void checkInIfRoomIsDirtyTest(){
        Room room = new Room();
        room.setDirty(true);
        room.checkIn();
        assertFalse(room.isOccupied());
    }
}
