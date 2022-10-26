package StrategyDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;
    public Cart(){
        items=new ArrayList<Product>();
    }

    public void addProduct(Product newProduct){
        items.add(newProduct);
    }

    public void order(Payment pay){
        pay.makePayment(this);
    }

    public List<Product> getItems(){
        return items;
    }
}
