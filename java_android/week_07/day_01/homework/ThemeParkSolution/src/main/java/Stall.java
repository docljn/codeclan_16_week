import Rides.IFunnable;

public class Stall implements IFunnable{
    
    private String product;
    private int funFactor;
    
    public Stall(String product, int funFactor){
        this.product = product;
        this.funFactor = funFactor;
    }
    
    public int calculateFunFactor() {
        return funFactor;
    }

    public String getProduct() {
        return product;
    }
}
