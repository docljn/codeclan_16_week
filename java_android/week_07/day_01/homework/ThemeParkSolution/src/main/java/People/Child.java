package People;

public class Child extends Person {

    public Child(String name, double funds, double height){
        super(name, funds, height);
    }

    public String favouriteRide(String ride) {
        return "I wanna go on the " + ride + "!";
    }


}


