package core.strategy;

public class DefaultStrategy implements OpenCloseStrategy {
    @Override
    public boolean isOpen(int time) {
        return true;
    }
}
