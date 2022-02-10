package java1.lesson6;

abstract public class Animals {
    protected final String NAME;

    public Animals(String NAME) {
        this.NAME = NAME;
    }

    protected abstract void run(int runLength);

    protected abstract void swim(int swimLength);


}
