public class MyAtomicTask implements Runnable {

    private final MyAtomicCounter counter;
    private final int id;
    private final Timer timer;

    public MyAtomicTask(MyAtomicCounter counter, int id, Timer atomicTimer) {
        this.counter = counter;
        this.id = id;
        this.timer = atomicTimer;
    }

    @Override
    public void run() {
        this.timer.Start(id);
        System.out.println("Starting run: " + Thread.currentThread().getName());
        counter.increment();
        System.out.println("Ending run: " + Thread.currentThread().getName());
        this.timer.Stop(id);
    }
}

