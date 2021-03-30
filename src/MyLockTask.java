
import java.util.concurrent.locks.Lock;

public class MyLockTask implements Runnable {

    private final MyLockCounter counter;
    private final int id;
    private final Timer timer;
    private final Lock lock;

    public MyLockTask(MyLockCounter counter, Lock lock, int id, Timer lockTimer) {
        this.counter = counter;
        this.lock = lock;
        this.id = id;
        this.timer = lockTimer;
    }

    @Override
    public void run() {
        this.timer.Start(id);
        System.out.println("Starting run: " + Thread.currentThread().getName());
        lock.lock();
        counter.increment();
        lock.unlock();
        System.out.println("Ending run: " + Thread.currentThread().getName());
        this.timer.Stop(id);
    }
}

