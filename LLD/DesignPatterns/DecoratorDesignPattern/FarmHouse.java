package DecoratorDesignPattern;

public class FarmHouse implements Pizza {
    @Override
    public int getPrice() {
        return 150;
    }

    @Override
    public String getDescription() {
        return "FarmHouse ";
    }
}
