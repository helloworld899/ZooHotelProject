
public class Ape extends Animal {

    //Konstruktor
    public Ape(String name, String favoriteActivity, String favoriteFood) {
        super(name,favoriteActivity, favoriteFood);
    }



    @Override
    public String getInfo() {
        String s = super.getInfo();
        return s + " ";
    }





}
