public class MyAtomicTask implements Runnable {

    private final MyAtomicCounter counter;
    private final int id;

    public MyAtomicTask(MyAtomicCounter counter, int id) {
        this.counter = counter;
        this.id = id;
    }

    @Override
    public void run() {
        MyAtomicProblem.AtomicTimer.Start(id);
        System.out.println("Starting run: " + Thread.currentThread().getName());
        try {
            Thread.sleep((long) (Math.random() * 100));
            counter.increment();
        } catch (InterruptedException e) {
            System.out.println("Sleeping error in: " + Thread.currentThread().getName());
        }
        System.out.println("Ending run: " + Thread.currentThread().getName());
        MyAtomicProblem.AtomicTimer.Stop(id);
    }
}

