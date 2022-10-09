package ObserverDesignPattern;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Listener> list=new ArrayList<>();
    public void register(Listener newListener){
        this.list.add(newListener);
    }

    public void unRegister(Listener oldLister){
        this.list.remove(oldLister);
    }

    private void notifyAllListeners(){
        for(Listener listener:list)
            listener.notifyMe();
    }

    public void succesfulOrder(){
        System.out.println("Order was successful, notifying listeners");
        this.notifyAllListeners();
    }
}
