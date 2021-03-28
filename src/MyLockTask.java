import java.util.concurrent.locks.Lock;

public class MyLockTask implements Runnable {

    private final MyLockCounter counter;
    private Lock lock;
    private final int id;
    public MyLockTask(MyLockCounter counter, Lock lock, int id) {
        this.counter = counter;
        this.lock = lock;
        this.id = id;
    }

    @Override
    public void run() {
        MyLockProblem.LockTimer.Start(id);
        System.out.println("Starting run: " + Thread.currentThread().getName());
        try {
            Thread.sleep((long) (Math.random() * 100));
            lock.lock();
            counter.increment();
            lock.unlock();
        } catch (InterruptedException e) {
            System.out.println("Sleeping error in: " + Thread.currentThread().getName());
        }
        System.out.println("Ending run: " + Thread.currentThread().getName());
        long endTime = System.currentTimeMillis();
        MyLockProblem.LockTimer.Stop(id);
    }
}

