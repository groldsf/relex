package core;

import java.util.List;

public class Maze {
    private final List<List<Cell>> map;

    private final Point startPoint;

    private final Point endPoint;

    public Maze(List<List<Cell>> map, Point startPoint, Point endPoint) {
        this.map = map;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Cell getCell(Point point){
        return map.get(point.getX()).get(point.getY());
    }

    public List<List<Cell>> getMap() {
        return map;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    @Override
    public String toString() {
        return "Maze{" +
                "map=" + map +
                ", startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                '}';
    }
}
