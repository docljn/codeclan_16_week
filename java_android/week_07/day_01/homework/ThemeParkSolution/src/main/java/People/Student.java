package People;

public class Student extends Person {

    public Student(String name, double funds, double height) {
        super(name, funds, height);
    }

    public String favouriteRide(String ride) {
        return "Can I use my student discount on " + ride + "?";
    }
}
