package DecoratorDesignPattern;

public class Main {
    public static void main(String[] args) {
        Pizza mypizza=new Cheese(
                new Olive(
                        new Tomato(
                                new Margherita())));
        System.out.println(mypizza.getPrice());
        System.out.println(mypizza.getDescription());

        Pizza p = new Paneer(new Cheese(new Tomato(new BBQChicken())));
        System.out.println(p.getPrice()); // should output 370
        System.out.println(p.getDescription()); // should output BBChicken +Tomato + Cheese + Paneer
    }
}
