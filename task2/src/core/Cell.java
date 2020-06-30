package core;

import core.strategy.DefaultStrategy;
import core.strategy.OpenCloseStrategy;

public class Cell {

    private final int height;
    private final Point point;

    private OpenCloseStrategy strategy;

    public Cell(int height, Point point) {
        this.height = height;
        this.point = point;
        strategy = new DefaultStrategy();
    }

    public boolean isWall() {
        return height == -1;
    }

    public boolean isOpen(int time){
        return strategy.isOpen(time);
    }

    public void setStrategy(OpenCloseStrategy strategy) {
        this.strategy = strategy;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "height=" + height +
                ", strategy=" + strategy +
                '}';
    }

    public Point getPoint() {
        return point;
    }
}
