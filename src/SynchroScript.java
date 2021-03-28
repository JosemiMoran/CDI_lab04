import java.io.IOException;

public class SynchroScript {
    public static void main(String args[]) throws IOException {
        int[] range = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
        Runtime runtime = Runtime.getRuntime();
        System.out.println("********");
        System.out.println("Compiling file...");
        System.out.println("********");
        runtime.exec("javac MySynchronizedProblem.java");
        for (int i = 0; i < range.length; i++) {
            runtime.exec("java MySynchronizedProblem " + range[i]);
        }
    }
}