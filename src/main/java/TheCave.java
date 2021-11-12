public class TheCave extends Room{

    //Konstruktor
    public TheCave(String roomNbr, int price) {
        super(roomNbr, price);
        roomName = "TheCave";
    }

    //Method
    public String getDescription() {
        String description = " Room designed as a cave with a single bed made of rocks";
        return description;
    }
}
