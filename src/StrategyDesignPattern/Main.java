package StrategyDesignPattern;

public class Main {
    public static void main(String[] args) {
        Cart myCart=new Cart();
        myCart.addProduct(new Product("Shirt",2,2500));
        myCart.addProduct(new Product("Trouser",2,1500));
        myCart.order(new PaymentbyBank());

        Cart cart2=new Cart();
        cart2.addProduct(new Product("sofa",1,35000.00));
        cart2.order(new PaymentbyCard());

        Cart cart3=new Cart();
        cart3.addProduct(new Product("Vegetables",7,40));
        cart3.addProduct(new Product("Groceries",15,23.00));
        cart3.order(new PaymentbyUPI());
    }
}
