package bridge.domain;

public class Logger {
    private final StringBuilder up = new StringBuilder("[");
    private final StringBuilder down = new StringBuilder("[");

    void put(Moving moving, boolean correct) {
        if (moving == Moving.UP) {
            addUp(correct);
            return;
        }
        addDown(correct);
    }

    private void addUp(boolean correct) {
        down.append("   |");
        if (correct) {
            up.append(" O |");
            return;
        }
        up.append("   |");
    }

    private void addDown(boolean correct) {
        up.append("   |");
        if (correct) {
            down.append(" O |");
            return;
        }
        down.append(" X |");
    }

    public String calculateMap() {
        StringBuilder firstLine = new StringBuilder(up);
        StringBuilder secondLine = new StringBuilder(down);
        firstLine.setCharAt(firstLine.length() - 1, ']');
        secondLine.setCharAt(secondLine.length() - 1, ']');
        return firstLine.toString() + "\n" + secondLine.toString();
    }
}
