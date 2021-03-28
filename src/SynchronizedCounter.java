public class SynchronizedCounter {

    private int accumulator;

    /**
     * @param n
     */
    public SynchronizedCounter(int n) {
        this.accumulator = 0;
    }

    public int getAccumulator() {
        return accumulator;
    }

    public void increment() {
        accumulator++;
    }
}

