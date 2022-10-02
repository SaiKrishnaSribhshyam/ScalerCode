package DecoratorDesignPattern;

public class Pepperoni implements Pizza {
    @Override
    public int getPrice() {
        return 180;
    }

    @Override
    public String getDescription() {
        return "Pepperoni ";
    }
}
