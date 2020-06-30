package core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    private final Maze maze;

    public Solution(Maze maze) {
        this.maze = maze;
    }

    public Result simulation(int startTime) {
        Result result = new Result();
        dfs(maze.getStartPoint(), startTime, result);
        return result;
    }

    private void dfs(Point point, int time, Result result) {
        if (point.equals(maze.getEndPoint())) {
            result.addTrueAnswer(time);
            return;
        }
        List<Point> points = findAdjacentCells(point);
        Cell targetCell = maze.getCell(point);
        List<Cell> nextCells = findNextCells(points, time, targetCell);
        if (nextCells.isEmpty()) {
            result.addFalseResult(time);
            return;
        }
        nextCells.forEach(cell -> dfs(cell.getPoint(), time + 1, result));
    }

    private List<Point> findAdjacentCells(Point point) {
        List<Point> points = new ArrayList<>();
        if (point.getX() > 0) {
            points.add(new Point(point.getX() - 1, point.getY()));
        }
        if (point.getY() > 0) {
            points.add(new Point(point.getX(), point.getY() - 1));
        }
        if (point.getX() < 7) {
            points.add(new Point(point.getX() + 1, point.getY()));
        }
        if (point.getY() < 7) {
            points.add(new Point(point.getX(), point.getY() + 1));
        }
        return points;
    }

    private List<Cell> findNextCells(List<Point> points, int time, Cell targetCell) {
        List<Cell> collect = points.stream()
                .map(maze::getCell)
                .filter(v -> !v.isWall() && v.isOpen(time + 1) && v.getHeight() < targetCell.getHeight())
                .collect(Collectors.toList());
        List<Cell> next = new ArrayList<>();
        for (Cell cell : collect) {
            if (next.isEmpty() || next.get(0).getHeight() == cell.getHeight()) {
                next.add(cell);
            } else if (next.get(0).getHeight() > cell.getHeight()) {
                next.clear();
                next.add(cell);
            }
        }
        return next;
    }
}
