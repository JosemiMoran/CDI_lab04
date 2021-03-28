
public class MyLockCounter {
    private int accumulator;

    /**
     * @param n
     */
    public MyLockCounter(int n) {
        this.accumulator = n;
    }

    public int getAccumulator() {
        return accumulator;
    }

    public void increment() {
        accumulator++;
    }
}

