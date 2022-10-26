package StrategyDesignPattern;

public class PaymentbyCard implements Payment{
    @Override
    public void makePayment(Cart myCart) {

        double total=0;
        for(Product product: myCart.getItems()){
            total+=product.getCost();
        }
        System.out.println("Making payment via Credit/Debit card:"+total);
    }
}
