package core.strategy;

public class OpenPeriodStrategy implements OpenCloseStrategy {

    private final int period;

    public OpenPeriodStrategy(int period) {
        this.period = period;
    }

    @Override
    public boolean isOpen(int time) {
        return time % period != 0;
    }
}
