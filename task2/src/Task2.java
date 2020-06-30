import core.Maze;
import core.Result;
import core.Solution;
import core.reader.MazeReader;
import core.reader.MazeReaderImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws IOException {
        for(int i = 0; i < 2; i++){
            MazeReader reader = new MazeReaderImpl();
            File input = new File("input2" + i + ".txt");
            File output = new File("output2" + i + ".txt");
            output.createNewFile();
            try (Scanner in = new Scanner(input); FileWriter out = new FileWriter(output)) {
                int startTime = in.nextInt();
                Maze maze = reader.read(in);
                Solution solution = new Solution(maze);
                Result result = solution.simulation(startTime);
                if(result.getFalseResult().size()==0){
                    out.write("YES");
                }else{
                    out.write("NO");
                }
            }
        }

    }
}
