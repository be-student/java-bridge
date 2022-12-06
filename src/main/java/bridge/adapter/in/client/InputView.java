package bridge.adapter.in.client;

import bridge.application.port.in.CreateBridgeCommand;
import bridge.application.port.in.MoveCommand;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String ASK_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String ASK_BRIDGE_MESSAGE = "다리의 길이를 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public CreateBridgeCommand readBridgeSize() {
        System.out.println(ASK_BRIDGE_MESSAGE);
        return new CreateBridgeCommand(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public MoveCommand readMoving() {
        System.out.println(ASK_MOVING_MESSAGE);
        return new MoveCommand(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
