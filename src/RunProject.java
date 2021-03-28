import java.io.IOException;

public class RunProject {
    public static void main(String args[]) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("********");
        System.out.println("Compiling files...");
        runtime.exec("javac AtomicScript.java");
        runtime.exec("javac LockScript.java");
        runtime.exec("javac SynchroScript.java");
        runtime.exec("javac AtomicPlot.java");
        runtime.exec("javac LockPlot.java");
        runtime.exec("javac SynchroPlot.java");
        System.out.println("Files compiled!");
        System.out.println("********");
        System.out.println("Running files...");
        runtime.exec("java AtomicScript.java");
        Thread.sleep(60000);
        runtime.exec("java LockScript.java");
        Thread.sleep(60000);
        runtime.exec("java SynchroScript.java");
        Thread.sleep(60000);
        System.out.println("********");
        System.out.println("Generating Plots...");
        runtime.exec("java AtomicPlot.java");
        runtime.exec("java LockPlot.java");
        runtime.exec("java SynchroPlot.java");
    }
}
