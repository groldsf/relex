package core.reader;

import core.Maze;

import java.io.FileNotFoundException;
import java.util.Scanner;

public interface MazeReader {

    Maze read(Scanner scanner) throws FileNotFoundException;

}
