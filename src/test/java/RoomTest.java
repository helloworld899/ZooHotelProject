import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void getRoomNr() {
        Room rooms = new Room();
        rooms.setRoomNr("102");
        assertTrue(rooms.getRoomNbr().equals("102"));

        }


    @Test
    void getPrice() {
        Room rooms = new Room();
        rooms.setPrice(45);
        assertTrue(rooms.getPrice() == 45);

    }

    @Test
    void getDescription() {
        Room rooms = new Room();
        rooms.getDescription();
        assertTrue(rooms.getDescription().equals("Comfortable and spacious rooms"));
    }
}