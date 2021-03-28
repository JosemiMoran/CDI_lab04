import java.util.ArrayList;

public class MyProblem {
    public static void main(String args[]) {
        System.out.println("Starting main");

        int numThreads = Integer.parseInt(args[0]);
        Counter counter = new Counter(0);
        ArrayList<Thread> threadArrayList = new ArrayList<>(numThreads);

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(new MyTask(counter), "Thread " + i);
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
                System.out.println("Join error in: " + Thread.currentThread().getName());
            }
        }
        System.out.println("Current counter value: " + counter.getAccumulator());
        System.out.println("Ending main");
    }

}
