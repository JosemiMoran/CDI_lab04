public class Counter {


    private int accumulator;

    /**
     * @param n
     */
    public Counter(int n) {
        this.accumulator = 0;
    }

    public int getAccumulator() {
        return accumulator;
    }

    public void increment() {
        accumulator++;
    }
}
