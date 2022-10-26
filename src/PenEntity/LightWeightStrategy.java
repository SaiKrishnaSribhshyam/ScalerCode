package PenEntity;

public class LightWeightStrategy implements WriteStrategy{

    @Override
    public void write() {
        System.out.println("This is leight weight Pen");
    }
}
