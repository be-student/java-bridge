package bridge.application.port.service;

import bridge.application.port.in.BridgeGameUseCase;
import bridge.application.port.in.CreateBridgeCommand;
import bridge.application.port.in.MoveCommand;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public final class BridgeGame implements BridgeGameUseCase {

    @Override
    public void createBridge(CreateBridgeCommand createBridgeCommand) {
    }
    

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    @Override
    public void move(MoveCommand moveCommand) {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    @Override
    public void retry() {
    }

    @Override
    public List<List<String>> result() {
        return null;
    }
}
