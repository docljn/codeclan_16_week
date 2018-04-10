package wizard_management.beasts;


import wizard_management.behaviours.IFlyable;

public class Dragon extends MythicalBeast implements IFlyable {

    public Dragon(String name){
        super(name);
    }

    public String fly(){
        return "Standing up tall, beating wings, lift off!";
    }

}
