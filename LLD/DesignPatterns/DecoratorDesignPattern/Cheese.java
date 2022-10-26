package DecoratorDesignPattern;

public class Cheese implements Pizza {
    private Pizza pc;
    public Cheese(Pizza pc){
        this.pc=pc;
    }

    @Override
    public int getPrice() {
        return this.pc.getPrice()+80;
    }

    @Override
    public String getDescription() {
        return this.pc.getDescription()+"Cheese ";
    }
}
