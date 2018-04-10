package People;

public abstract class Person {

    private String name;
    private double funds;
    private double height;

    public Person(String name, double funds, double height){
        this.name = name;
        this.funds = funds;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public double getFunds() {
        return funds;
    }

    public double getHeight() {
        return height;
    }

    public abstract String favouriteRide(String ride);

    public void spendMoney(double cost){
        this.funds -= cost;
    }

}
