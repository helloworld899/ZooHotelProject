public class UrbanStay extends Room{

    //Konstruktor
    public UrbanStay(String roomNbr, int price) {
        super(roomNbr, price);
        roomName = "UrbanStay";
    }

    //Method Override
    public String getDescription() {
        return  " Room with double bed and amazing view of the city";

    }
}
