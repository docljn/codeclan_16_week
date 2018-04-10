package Rides;

import People.Person;

import java.util.ArrayList;

public abstract class Ride implements IFunnable{

    private double price;
    private double minHeight;
    private int capacity;
    private ArrayList<Person> queue;
    protected int funFactor;

    public Ride(int capacity, double price, double minHeight, int funFactor){
        this.capacity = capacity;
        this.price = price;
        this.minHeight = minHeight;
        this.queue = new ArrayList<>();
        this.funFactor = funFactor;
    }

    public double getPrice() {
        return price;
    }

    public double getMinHeight() {
        return minHeight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addToQueue(Person person){
        if(person.getFunds() >= getPrice() && person.getHeight() >= getMinHeight()){
            person.spendMoney(getPrice());
            this.queue.add(person);
        }
    }

    public int queueSize(){
        return this.queue.size();
    }

    public boolean queueOverCapacity(){
        return queueSize() > this.capacity;
    }

    public void board(){
        int customersToBoard = queueOverCapacity() ? getCapacity() : queueSize();
            for(int i = 0; i < customersToBoard; i++){
                this.queue.remove(0);
            }
        }

    public abstract String go();
    public abstract int calculateFunFactor();
}
