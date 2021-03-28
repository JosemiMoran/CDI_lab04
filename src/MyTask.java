public class MyTask implements Runnable {

    private final Counter counter;

    public MyTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("Starting run: " + Thread.currentThread().getName());
        try {
            Thread.sleep((long) (Math.random() * 100));
            counter.increment();
        } catch (InterruptedException e) {
            System.out.println("Sleeping error in: " + Thread.currentThread().getName());
        }
        System.out.println("Ending run: " + Thread.currentThread().getName());

    }
}
