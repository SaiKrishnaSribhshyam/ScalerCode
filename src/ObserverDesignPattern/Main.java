package ObserverDesignPattern;

public class Main {
    public static void main(String[] args) {
        Cart myCart=new Cart();
        SendEmail mail=new SendEmail();
        myCart.register(mail);
        myCart.register(new UpdateInventory());
        myCart.succesfulOrder();
        myCart.unRegister(mail);
        myCart.succesfulOrder();
    }
}
