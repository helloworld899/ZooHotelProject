
public class Dog extends Animal {

    //Konstruktor
    public Dog(String name, String favoriteActivity, String favoriteFood) {
        super(name, favoriteActivity, favoriteFood);
    }


    @Override
    public String getInfo() {
        String s = super.getInfo();
        return s + " ";
    }
}


