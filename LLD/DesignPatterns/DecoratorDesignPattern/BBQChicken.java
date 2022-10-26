package DecoratorDesignPattern;

public class BBQChicken implements Pizza {
    @Override
    public int getPrice() {
        return 200;
    }

    @Override
    public String getDescription() {
        return "BBQChicken ";
    }
}
