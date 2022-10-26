package PenEntity;

public class GelPen extends Pen{
private Ink ink;
private Refill refil;
    GelPen(WriteStrategy writeStrategy) {
        super(writeStrategy);
    }

    @Override
    public void write() {
        this.getWriteStrategy().write();
    }
}
