package bridge.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Bridge {
    private static final int ZERO_COUNt = 0;
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
//        System.out.println(bridge);
    }

    public boolean isRemained(Visited visited) {
        if (visited.size() == bridge.size()) {
            return false;
        }
        return !hasDifferent(visited);
    }

    public GameSuccessCondition result(Visited visited) {
        if (visited.size() != bridge.size()) {
            return GameSuccessCondition.FAILURE;
        }
        return GameSuccessCondition.from(!hasDifferent(visited));
    }

    private boolean hasDifferent(Visited visited) {
        return IntStream.range(ZERO_COUNt, visited.size())
                .anyMatch(index -> visited.isNotEqual(index, bridge.get(index)));
    }

    public String get(int index) {
        return bridge.get(index);
    }
}
