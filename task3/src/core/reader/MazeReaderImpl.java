package core.reader;

import core.Cell;
import core.Maze;
import core.Point;
import core.strategy.ClosePeriodStrategy;
import core.strategy.OpenPeriodStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeReaderImpl implements MazeReader {

    public Maze read(Scanner scanner) {
        Point startPoint = readPoint(scanner);
        Point endPoint = readPoint(scanner);
        List<List<Cell>> map = readMap(scanner);
        readOpenPeriodCells(scanner, map);
        readClosePeriodCells(scanner, map);
        return new Maze(map, startPoint, endPoint);
    }

    private void readOpenPeriodCells(Scanner scanner, List<List<Cell>> map) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Point point = readPoint(scanner);
            int period = scanner.nextInt();
            map.get(point.getX()).get(point.getY()).setStrategy(new OpenPeriodStrategy(period));
        }
    }

    private void readClosePeriodCells(Scanner scanner, List<List<Cell>> map) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Point point = readPoint(scanner);
            int period = scanner.nextInt();
            map.get(point.getX()).get(point.getY()).setStrategy(new ClosePeriodStrategy(period));
        }
    }

    private List<List<Cell>> readMap(Scanner scanner) {
        List<List<Cell>> map = new ArrayList<>();
        int n = 8;
        for (int i = 0; i < n; i++) {
            List<Cell> line = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                line.add(new Cell(scanner.nextInt(), new Point(i, j)));
            }
            map.add(line);
        }
        return map;
    }

    private Point readPoint(Scanner scanner) {
        return new Point(scanner.nextInt() - 1, scanner.nextInt() - 1);
    }
}
