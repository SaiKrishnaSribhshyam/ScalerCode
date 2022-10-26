package PenEntity;

public class BallpointPen extends Pen{
    private Refill refill;
    private Ink ink;

    BallpointPen(WriteStrategy writeStrategy){
        super(writeStrategy);
    }

    @Override
    public void write() {
        this.getWriteStrategy().write();
    }
}
