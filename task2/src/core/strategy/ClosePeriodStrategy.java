package core.strategy;

public class ClosePeriodStrategy implements OpenCloseStrategy {

    private final int period;

    public ClosePeriodStrategy(int period) {
        this.period = period;
    }

    @Override
    public boolean isOpen(int time) {
        return time % period == 0;
    }
}
