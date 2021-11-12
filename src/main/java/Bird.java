
public class Bird extends Animal {

    //Konstruktor
   public Bird(String name, String favoriteActivity, String favoriteFood) {
        super(name, favoriteActivity, favoriteFood);
    }



    @Override
    public String getInfo() {
        String s = super.getInfo();
        return s + " ";
    }
}