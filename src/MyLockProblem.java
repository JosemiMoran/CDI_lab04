import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLockProblem {
    public static Timer LockTimer;


    public static void main(String args[]) {

        System.out.println("Starting main");
        int numThreads = Integer.parseInt(args[0]);
        LockTimer = new Timer(numThreads);
        MyLockCounter counter = new MyLockCounter(0);
        Lock lock = new ReentrantLock();
        ArrayList<Thread> threadArrayList = new ArrayList<>(numThreads);

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(new MyLockTask(counter, lock, i), "Thread " + i);
            System.out.println("Creating: " + thread.getName());
            threadArrayList.add(thread); // Adding the thread into the arraylist
        }

        for (Thread thread : threadArrayList
        ) {
            thread.start();
        }

        for (Thread thread : threadArrayList
        ) {
            try {
                thread.join();

            } catch (InterruptedException e) {
                System.out.println("Join error in: " + thread.getName());
            }
        }
        System.out.println("Current counter value: " + counter.getAccumulator());
        double duration = LockTimer.Elapsed();
        System.out.println("The total duration is:" + duration);
        System.out.println("Ending main");
        appendUsingPrintWriter("lockValues.txt", numThreads, duration);

    }

    private static void appendUsingPrintWriter(String filePath, int numThreads, double duration) {
        File file = new File(filePath);
        FileWriter fr = null;
        BufferedWriter br = null;
        PrintWriter pr = null;
        try {
            // to append to file, you need to initialize FileWriter using below constructor
            fr = new FileWriter(file, true);
            br = new BufferedWriter(fr);
            pr = new PrintWriter(br);
            pr.println(numThreads + " " + duration);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


