package Rides;

public class Dodgems extends Ride implements Rides.IFunnable {

    public Dodgems(int capacity, double price, double minHeight, int funFactor) {
        super(capacity, price, minHeight, funFactor);
    }

    public String go() {
        return "SOUND OF PEOPLE BUMPING CARS FOR AMUSEMENT";
    }

    public int calculateFunFactor() {
        return this.funFactor * getCapacity();
    }
}
