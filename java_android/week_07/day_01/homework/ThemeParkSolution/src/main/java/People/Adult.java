package People;

public class Adult extends Person {

    public Adult(String name, double funds, double height){
        super(name, funds, height);
    }

    public String favouriteRide(String ride){
        return "I have too many adult responsibilities! I'm not sure I can afford to go on " + ride + "...";
    }

}

