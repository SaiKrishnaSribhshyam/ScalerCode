package ObserverDesignPattern;

import java.util.List;

public class UpdateInventory implements Listener {
    @Override
    public void notifyMe() {
        System.out.println("Updating Inventory");
    }
}
