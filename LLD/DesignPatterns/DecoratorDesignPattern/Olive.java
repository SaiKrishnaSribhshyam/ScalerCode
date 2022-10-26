package DecoratorDesignPattern;

public class Olive implements Pizza {
    private Pizza pc;
    public Olive(Pizza pc){
        this.pc=pc;
    }

    @Override
    public int getPrice() {
        return this.pc.getPrice()+20;
    }

    @Override
    public String getDescription() {
        return this.pc.getDescription()+"Olive ";
    }
}
