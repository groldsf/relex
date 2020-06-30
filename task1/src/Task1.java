import core.Maze;
import core.Result;
import core.Solution;
import core.reader.MazeReader;
import core.reader.MazeReaderImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws IOException {
        MazeReader reader = new MazeReaderImpl();
        File input = new File("input1.txt");
        File output = new File("output1.txt");
        output.createNewFile();
        try (Scanner in = new Scanner(input); FileWriter out = new FileWriter(output)) {
            int startTime = in.nextInt();
            Maze maze = reader.read(in);
            Solution solution = new Solution(maze);
            Result simulation = solution.simulation(startTime);
            for (Integer integer : simulation.getTrueResult()) {
                out.write(integer + " ");
            }
        }
    }
}
