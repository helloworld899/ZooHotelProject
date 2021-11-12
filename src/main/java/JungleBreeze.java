public class JungleBreeze extends Room{

    //Konstruktor
    public JungleBreeze(String roomNbr, int price) {
        super(roomNbr, price);
        roomName = "JungleBreeze";
    }

    //Method
    public String getDescription() {
        String description = " Room with double bed and sofa. Also with balcony";
        return description;
    }
}
