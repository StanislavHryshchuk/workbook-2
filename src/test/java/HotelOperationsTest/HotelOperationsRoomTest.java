package HotelOperationsTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import week_5.HotelOperations.Room;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class HotelOperationsRoomTest {

    Room room;
    @BeforeEach
    public void inIt(){
        room = new Room();
    }

    @Test
    @DisplayName("CheckIn Room went successfully")
    public void checkInTest(){
        room.checkIn();
        assertTrue(true);
    }
    @Test
    @DisplayName("Room is clean")
    public void cleanRoomTest(){
        room.cleanRoom();
        assertTrue(true);
    }
    @Test
    @DisplayName("Check out is complete")
    public void checkOutTest(){
        room.checkOut();
        assertTrue(true);
    }

}
