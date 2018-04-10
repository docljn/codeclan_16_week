package Rides;

public class Waltzer extends Ride implements Rides.IFunnable {

    public Waltzer(int capacity, double price, double minHeight, int funFactor) {
        super(capacity, price, minHeight, funFactor);
    }

    public String go() {
        return "Scream if you wanna go faster!";
    }

    public int calculateFunFactor() {
        return this.funFactor/getCapacity();
    }
}
