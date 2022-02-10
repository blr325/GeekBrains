package java1.lesson6;

public class Cat extends Animals {
    private final int MAX_RUN = 200;
    private final int MAX_SWIM = 0;
    private int count;

    public Cat(String NAME) {
        super(NAME);
        count++;
    }

    @Override
    protected void run(int runLength) {
        if (isCheckRun(runLength)) {
            System.out.printf("Кот %s пробежал %d м.\n",NAME, runLength);
        } else System.out.printf("Кот %s не может пробежать больше %d м.\n", NAME, MAX_RUN);
    }

    @Override
    protected void swim(int swimLength) {
        if (MAX_SWIM == 0) {
            System.out.printf("Кот %s не умеет плавать\n", NAME);
        } else if (isCheckSwim(swimLength)) {
            System.out.printf("Кот %s проплыл %d м.\n", NAME, swimLength);
        } else System.out.printf("Кот %s не может проплыть больше %d м.\n", NAME, MAX_SWIM);
    }

    private boolean isCheckRun(int runLength) {
        return runLength <= MAX_RUN;
    }

    private boolean isCheckSwim(int swimLength) {
        return swimLength <= MAX_SWIM;
    }

    public int getCount() {
        return count;
    }
}
