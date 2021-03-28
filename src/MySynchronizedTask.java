public class MySynchronizedTask implements Runnable {

    private final SynchronizedCounter counter;
    private final int id;
    public MySynchronizedTask(SynchronizedCounter counter, int id) {
        this.counter = counter;
        this.id = id;
    }

    @Override
    public void run() {
        MySynchronizedProblem.SynchroTimer.Start(id);
        System.out.println("Starting run: " + Thread.currentThread().getName());
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
            System.out.println("Sleeping error in: " + Thread.currentThread().getName());
        }
        synchronized (counter) {
            counter.increment();
        }
        System.out.println("Ending run: " + Thread.currentThread().getName());
        MySynchronizedProblem.SynchroTimer.Stop(id);

    }
}

