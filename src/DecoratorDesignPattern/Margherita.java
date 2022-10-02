package DecoratorDesignPattern;

public class Margherita implements Pizza {
    @Override
    public int getPrice() {
        return 200;
    }

    @Override
    public String getDescription() {
        return "Margherita ";
    }
}
