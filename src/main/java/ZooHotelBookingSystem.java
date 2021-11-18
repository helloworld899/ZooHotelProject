import java.util.ArrayList;
import java.util.Scanner;

public class ZooHotelBookingSystem {
    static ArrayList<Room> rooms = new ArrayList<>();

    static String slogan;

    public ZooHotelBookingSystem(String slogan) {
        this.slogan = slogan;
    }


    public static void start() {

        /*
        Hårdkodade rum, användaren kan ej ta
        bort/lägga till rum när programmet körs.
         */
        TheCave room02 = new TheCave("101", 45);
        rooms.add(room02);

        JungleBreeze room03 = new JungleBreeze("102", 50);
        rooms.add(room03);

        UrbanStay room04 = new UrbanStay("103", 60);
        rooms.add(room04);


        boolean runProgram = true;
        while (runProgram) {
            printMenu();
            int dataInput = getUserInt();
            switch (dataInput) {
                case 1 -> printAllRooms();
                case 2 -> reserveRooms();
                case 3 -> showBookings();
                case 4 -> changeBooking();
                case 5 -> deleteBooking();
                case 6 -> searchBookings();
                case 7 -> searchGuests();
                case 8 -> {
                    runProgram = false;
                    System.out.println(" Thank you and welcome back");
                }
            }
        }
    }

    public static void printMenu() {
        System.out.println("============================");
        System.out.println("    Welcome To ZooHotel");
        System.out.println("============================ \n");
        System.out.println(" 1. List of all rooms");
        System.out.println(" 2. Reserve/Check-in room");
        System.out.println(" 3. Show the bookings");
        System.out.println(" 4. Change bookings");
        System.out.println(" 5. Delete bookings");
        System.out.println(" 6. Search for bookings");
        System.out.println(" 7. Filter search");
        System.out.println(" 8. Quit program");
        System.out.println("=============================");
        System.out.print("> ");

    }


    public static String getUserString() {
        Scanner myScan = new Scanner(System.in);
        String userInput = myScan.nextLine();

        return userInput;
    }

    public static int getUserInt() {
        //Här nedan sker en typkonvertering för att konvertera en int till en String
        Scanner myScan = new Scanner(System.in);
        int userInput;

        while (true) {
            try {
                userInput = Integer.parseInt(myScan.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Sorry, wrong input. Try again");
            }

        }
        return userInput;
    }

    //Här kan vi få alla rum utskriven som en lista m.h.a foreach-loop.
    public static void printAllRooms() {
        System.out.println(slogan);
        System.out.println(" \n");

        int counter = 1;
        for (Room room : rooms) {
            System.out.println(counter + ". " + room.roomName + ": " + room.getStatus() + " - " + room.getDescription() + " and it costs " + room.getPrice() + " $ /night");
            counter++;
        }
    }

    //Visar upp bokningar som har gjorts m.h.a foreach-loop.
    public static void showBookings() {

        int counter = 1;
        for (Room room : rooms) {
            if (!room.isEmpty()) {
                System.out.println(" " + room.roomName + " RoomNbr " + counter + ":  " + room.getStatus() + " by " + room.getGuest().getName() +
                        (", | Favorite food: ") + room.getGuest().getFavoriteFood() + (" | Favorite activity: ") + room.getGuest().getFavoriteActivity());
            }
            counter++;
        }
    }


    public static void reserveRooms() {
        System.out.println("Rooms available \n");
        printAllRooms();
        System.out.println(" \n");
        System.out.print("> ");

        System.out.println("Please type in all info about the guest down below \n");
        System.out.println(" What type of animal are you?");
        String animalType = getUserString();
        System.out.println("Guest's name");

        System.out.print("> ");
        String guestName = getUserString();

        System.out.println("Favorite activity");
        System.out.print("> ");
        String favoriteActivity = getUserString();

        System.out.println("Favorite food");
        System.out.print("> ");
        String favoriteFood = getUserString();

        printAllRooms();
        System.out.println(" ");
        System.out.println(" Which room would you like to book?");
        System.out.print("> ");
        int r = Integer.parseInt(getUserString());
        System.out.println("Room " + r + " is booked.");

        switch (animalType) {
            case "Ape" -> {
                Ape myApe = new Ape(guestName, favoriteActivity, favoriteFood);
                rooms.get(r - 1).book(myApe);
            }
            case "Shark" -> {
                Shark myShark = new Shark(guestName, favoriteActivity, favoriteFood);
                rooms.get(r - 1).book(myShark);

            }
            case "Bird" -> {
                Bird myBird = new Bird(guestName, favoriteActivity, favoriteFood);
                rooms.get(r - 1).book(myBird);
            }
            case "Dog" -> {
                Dog myDog = new Dog(guestName, favoriteActivity, favoriteFood);
                rooms.get(r - 1).book(myDog);

            }
            default -> {
                Animal x = new Animal(guestName, favoriteActivity, favoriteFood);
                rooms.get(r - 1).book(x);
            }
        }
    }

    public static void changeBooking() {

        System.out.println(" Which room do you belong to?");
        int n1 = getUserInt();

        System.out.println(" What would you like to change?");

        System.out.println(" 1. Favourite Activity?");
        System.out.println(" 2. Favourite Food?");
        int n2 = getUserInt();
        System.out.println(" What would you like to change to?");
        String s = getUserString();
        // Här tar vi svaret från användaren som är av typen int och sätter -1,för att få fram rätt index från vår arrayList.
        if (n2 == 1 && !rooms.get(n1 - 1).isEmpty) {
            rooms.get(n1 - 1).getGuest().setFavoriteActivity(s);
        } else if (n2 == 2 && !rooms.get(n1 - 1).isEmpty) {
            rooms.get(n1 - 1).getGuest().setFavoriteFood(s);

        } else {
            System.out.println("Invalid input");
        }
    }

    public static void searchBookings() {
        System.out.println("Search either guest or room");
        System.out.print("> ");
        String s1 = getUserString();

        // Använder en for-loop med två if-satser. Första f-satsen för att loopa igenom rummen med gäster och
        // den andra if-satsen körs för att filtrera gästerna med bokstäverna som användaren angett.

        if (s1.equals("guest")) {
            System.out.println(" What's the name of the guest?");
            String s2 = getUserString();
            String answer = " There is no guest by that name";
            for (int i = 0; i < rooms.size(); i++) {
                if (!rooms.get(i).isEmpty()) {

                    if (rooms.get(i).getGuest().getName().equals(s2)) {
                        answer = (rooms.get(i).getGuest().getInfo() + "\n"+
                                "Booked in room " + rooms.get(i).getRoomNbr() + ", " + rooms.get(i).getPrice() + "$/night" +
                                " |" + rooms.get(i).getDescription());
                        i = rooms.size();
                    }
                }
            }
            System.out.println(answer);

        } else if (s1.equals("room")) {
            System.out.println("  Which room number?");
            int n = getUserInt() - 1;
            if (!rooms.get(n).isEmpty()) {
                System.out.println(rooms.get(n).getGuest().getInfo());

            } else {
                System.out.println(" There is no guest in this room");
            }

        } else {
            System.out.println(" Invalid input");
        }
    }


    public static void searchGuests() {
        System.out.println(" Type in any letter of the guest's name ");
        System.out.print("> ");
        String letter = getUserString();
        // Foreach -loop används ej i detta fall då det inte kan hämta en viss uppsättning element.
        // Dock kan for-loop göra det.
        boolean matchingName = false;
        for (int i = 0; i < rooms.size(); i++) {
            //m.h.a. Metoden contains nedan kan vi filtrera sökningen efter gästernas namn i bokningen.
            // Går även att använda en if-sats istället för try & catch, vilket rekommenderas egentligen.
            if (rooms.get(i).getGuest() != null && rooms.get(i).getGuest().getName().toLowerCase().contains(letter.toLowerCase())) {
                System.out.println("Guest name: " + rooms.get(i).getGuest().getName());

                matchingName = true;

                          /*
                          I if-satsen ovan har vi behövt använda oss utav String metoden .toLowerCase() för 'getName()'
                          samt inputen 'letter' för att programmet skall kunna matcha stor och liten bokstav utifrån
                          det användaren har skrivit som input i systemet.
                           */
            }
        }
        if (!matchingName) {
            System.out.println("There is no guest with the letter: " + letter);
        }
    }


    public static void deleteBooking() {
        System.out.println(" Which room do you belong to??");
        int n = getUserInt();

        if (!rooms.get(n - 1).isEmpty()) {
            rooms.get(n - 1).removeBooking();
            System.out.println("Booking is now deleted");

        } else {
            System.out.println(" This room is not booked");
        }
    }
}




