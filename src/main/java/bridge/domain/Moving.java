package bridge.domain;

import java.util.Arrays;
import java.util.Objects;

public enum Moving {
    UP("U"),
    DOWN("D");

    private final String move;

    Moving(String move) {
        this.move = move;
    }

    public static Moving from(String move) {
        return Arrays.stream(Moving.values())
                .filter(it -> Objects.equals(it.move, move))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("U,D 만 입력 가능합니다"));
    }

    public String getMove() {
        return move;
    }
}
