
public class Shark extends Animal {

     //Konstruktor
      public Shark(String name, String favoriteActivity, String favoriteFood) {
         super(name, favoriteActivity, favoriteFood);
      }


    @Override
    public String getInfo() {
        String s = super.getInfo();
        return s + " ";
    }
}




