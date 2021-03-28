import javax.swing.*;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

import org.math.plot.*;

public class LockPlot {
    public static void main(String[] args) {
        try {
            File myObj = new File("./src/lockValues.txt");
            Path path = Paths.get("./src/lockValues.txt");
            int numLines;
            try (Stream<String> lines = Files.lines(path, Charset.defaultCharset())) {
                numLines = (int) lines.count();
            }
            Scanner myReader = new Scanner(myObj);
            double[] x = new double[numLines];
            double[] y = new double[numLines];
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                double numThreads = Double.parseDouble(data.split(" ")[0]);
                x[i] = numThreads;
                double duration = Double.parseDouble(data.split(" ")[1]);
                y[i] = duration;
                System.out.println(x[i] + "----->" + y[i]);
                i++;
            }
            myReader.close();

            Plot2DPanel plot = new Plot2DPanel();

            // define the legend position
            plot.addLegend("SOUTH");

            // add a line plot to the PlotPanel
            plot.addLinePlot("CDI LAB04 LOCK", x, y);

            // put the PlotPanel in a JFrame like a JPanel
            JFrame frame = new JFrame("CDI LAB04 LOCK");
            frame.setSize(600, 600);
            frame.setContentPane(plot);
            frame.setVisible(true);

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            e.getMessage();
        }
    }
}
