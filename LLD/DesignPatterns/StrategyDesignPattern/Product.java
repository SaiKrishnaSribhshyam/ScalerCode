package StrategyDesignPattern;

public class Product {
    private String name;
    private int quantity;
    private double price;

    public Product(String name,int quantity,double price){
        this.name=name;
        this.quantity=quantity;
        this.price=price;
    }

    public double getCost(){
        return quantity*price;
    }
}
