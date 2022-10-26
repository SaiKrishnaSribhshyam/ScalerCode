package DecoratorDesignPattern;

public class Tomato implements Pizza {
    private Pizza pc;
    public Tomato(Pizza pc){
        this.pc=pc;
    }

    @Override
    public int getPrice() {
        return this.pc.getPrice()+30;
    }

    @Override
    public String getDescription() {
        return this.pc.getDescription()+"Tomato ";
    }
}
