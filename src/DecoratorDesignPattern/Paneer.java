package DecoratorDesignPattern;

public class Paneer implements Pizza {
    private Pizza pc;
    public Paneer(Pizza pc){
        this.pc=pc;
    }

    @Override
    public int getPrice() {
        return this.pc.getPrice()+60;
    }

    @Override
    public String getDescription() {
        return this.pc.getDescription()+"Paneer ";
    }
}
