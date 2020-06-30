import core.Maze;
import core.Result;
import core.Solution;
import core.reader.MazeReader;
import core.reader.MazeReaderImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.min;

public class Task4 {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 2; i++) {
            MazeReader reader = new MazeReaderImpl();
            File input = new File("input4" + i + ".txt");
            File output = new File("output4" + i + ".txt");
            output.createNewFile();
            try (Scanner in = new Scanner(input); FileWriter out = new FileWriter(output)) {
                Maze maze = reader.read(in);
                Solution solution = new Solution(maze);
                int minimalTime = Integer.MAX_VALUE;
                final int maxTime = 10_000_000;
                for (int startTime = 1; startTime < maxTime && startTime < minimalTime; startTime++) {
                    Result result = solution.simulation(startTime);
                    if (result.getFalseResult().isEmpty() && !result.getTrueResult().isEmpty()){
                        Integer minres = result.getTrueResult().iterator().next();
                        minimalTime = min(minimalTime, minres);
                    }
                }
                out.write(minimalTime + "");
            }
        }

    }
}
