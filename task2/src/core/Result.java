package core;

import java.util.HashSet;
import java.util.Set;

public class Result {

    private final Set<Integer> trueResult = new HashSet<>();
    private final Set<Integer> falseResult = new HashSet<>();

    public void addTrueAnswer(int time) {
        trueResult.add(time);
    }

    public void addFalseResult(int time) {
        falseResult.add(time);
    }

    public Set<Integer> getTrueResult() {
        return trueResult;
    }

    public Set<Integer> getFalseResult() {
        return falseResult;
    }
}
