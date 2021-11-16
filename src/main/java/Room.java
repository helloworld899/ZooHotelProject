public class Room {

    //Attributer
    public String roomName;
    public String roomNbr;
    public int price;
    public String description;
    public Animal guest;
    public boolean isEmpty;


    //Konstruktor 1
    public Room(String roomNbr, int price, Animal guest) {

        this.setRoomNr(roomNbr);
        this.setPrice(price);
        this.setDescription(" normal room with normal sized bed");
        this.setGuest(guest);
        this.roomName = "Room";
        isEmpty = false;
    }

    //Konstruktor 2
    public Room(String roomNbr, int price) {

        this.setRoomNr(roomNbr);
        this.setPrice(price);
        this.setDescription(" normal room with normal sized bed");
        this.roomName = "Room";
        isEmpty = true;
    }

    //3:e konstruktorn
    public Room() {}


    //Getters & Setters
    public String getRoomNbr() {
        return roomNbr;
    }

    public void setRoomNr(String roomNbr) {
        this.roomNbr = roomNbr;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //Overriding method --> overridden in the three separate sub-room classes
    String getDescription() {
        return "Comfortable and spacious rooms";
    }

   private void setDescription(String description) {
        this.description = description;
    }

    public Animal getGuest() {
        return guest;
    }

    public void setGuest(Animal guest) {
        this.guest = guest;
        isEmpty = false;
    }

    //Methods

    public void book(Animal a) {
        guest = a;
        isEmpty = false;
    }

    public void removeBooking() {
        guest = null;
        isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public String getStatus() {
        if (isEmpty)
            return "Available";
        else
            return "Booked";
    }

    public String toString() {
        return roomNbr + " " + price + " " + description + " " + guest + " "
                + isEmpty;
    }

}
