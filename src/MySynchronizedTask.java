public class MySynchronizedTask implements Runnable {

    private final SynchronizedCounter counter;
    private final int id;
    private final Timer timer;

    public MySynchronizedTask(SynchronizedCounter counter, int id, Timer synchroTimer) {
        this.counter = counter;
        this.id = id;
        this.timer = synchroTimer;
    }

    @Override
    public void run() {
        this.timer.Start(id);
        System.out.println("Starting run: " + Thread.currentThread().getName());
        synchronized (counter) {
            counter.increment();
        }
        System.out.println("Ending run: " + Thread.currentThread().getName());
        this.timer.Stop(id);
    }
}

