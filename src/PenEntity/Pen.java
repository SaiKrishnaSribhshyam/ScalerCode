package PenEntity;

public abstract class Pen {
    private String name;
    private String brand;
    private WriteStrategy writeStrategy;
    private Cap cap;

    public WriteStrategy getWriteStrategy() {
        return writeStrategy;
    }

    public void setWriteStrategy(WriteStrategy writeStrategy) {
        this.writeStrategy = writeStrategy;
    }

    Pen(WriteStrategy writeStrategy){
        this.writeStrategy=writeStrategy;
    }

    public abstract void write();
}
