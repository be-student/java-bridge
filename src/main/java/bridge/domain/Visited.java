package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Visited {
    private final List<Moving> visited;

    public Visited() {
        visited = new ArrayList<>();
    }

    public void move(Moving moving) {
        visited.add(moving);
    }

    public int size() {
        return visited.size();
    }

    public boolean isNotEqual(int index, String piece) {
        Moving moving = visited.get(index);
        return moving != Moving.from(piece);
    }

    public String printVisited(Bridge bridge) {
        Logger logger = new Logger();
        for (int i = 0; i < visited.size(); i++) {
            logger.put(visited.get(i), visited.get(i) == Moving.from(bridge.get(i)));
        }
        return logger.calculateMap();
    }
}
