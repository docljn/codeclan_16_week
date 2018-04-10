package wizard_management.people;


import wizard_management.behaviours.IFlyable;

public class Wizard {
    private String name;
    private IFlyable ride;

    public Wizard(String name, IFlyable ride){
        this.name = name;
        this.ride = ride;
    }

    public String getName(){
        return this.name;
    }

    public IFlyable getRide(){
        return this.ride;
    }

    public void setRide(IFlyable ride){
        this.ride = ride;
    }

    public String fly(){
        return this.ride.fly();
    }

}
