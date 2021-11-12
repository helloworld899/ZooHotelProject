public class Animal {

    //Attributer
    private String name;
    private String favoriteActivity;
    private String favoriteFood;



    //Konstruktor
    public Animal(String name, String favoriteActivity, String favoriteFood) {

        this.setName(name);
        this.setFavoriteActivity(favoriteActivity);
        this.setFavoriteFood(favoriteFood);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteActivity() {
        return favoriteActivity;
    }

    public void setFavoriteActivity(String favoriteActivity) {
        this.favoriteActivity = favoriteActivity;
    }


    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getInfo() {
        return (name + " " + " " + " FavoritAktivitet:" + " " + favoriteActivity + " " + " FavoriteFood:" + " " + favoriteFood);
    }
}


