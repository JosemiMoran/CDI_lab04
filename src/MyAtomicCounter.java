import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicCounter {
    AtomicInteger atomicInteger;

    /**
     * @param n
     */
    public MyAtomicCounter(int n) {
        atomicInteger = new AtomicInteger(0);
    }

    public int getAccumulator() {
        return atomicInteger.get();
    }

    public void increment() {
        atomicInteger.incrementAndGet();
    }
}

