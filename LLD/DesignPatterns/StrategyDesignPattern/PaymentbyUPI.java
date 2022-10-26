package StrategyDesignPattern;

public class PaymentbyUPI implements Payment{
    @Override
    public void makePayment(Cart myCart) {
        double total=0;
        for(Product product: myCart.getItems()){
            total+=product.getCost();
        }
        System.out.println("Making payment using UPI:"+total);
    }
}
