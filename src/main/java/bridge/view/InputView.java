package bridge.view;

import bridge.domain.ControllerCommand;
import bridge.domain.Moving;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        int length = Integer.parseInt(input);
        if (length < 3) {
            throw new IllegalArgumentException();
        }
        if (length > 20) {
            throw new IllegalArgumentException();
        }
        return length;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Moving readMoving() {
        String input = Console.readLine();
        return Moving.from(input);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public ControllerCommand readGameCommand() {
        String input = Console.readLine();
        return ControllerCommand.from(input);
    }
}
