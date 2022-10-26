package PenEntity;

public class FountainPen extends Pen{
    private Ink ink;

    FountainPen(WriteStrategy writeStrategy) {
        super(writeStrategy);
    }

    @Override
    public void write() {
        this.getWriteStrategy().write();
    }
}
