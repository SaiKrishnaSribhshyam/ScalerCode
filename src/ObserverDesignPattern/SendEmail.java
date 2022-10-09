package ObserverDesignPattern;

public class SendEmail implements Listener{
    @Override
    public void notifyMe() {
        System.out.println("Sending mail");
    }
}
