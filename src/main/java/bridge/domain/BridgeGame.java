package bridge.domain;

import bridge.BridgeMaker;
import bridge.dto.BridgeGameResultDto;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;
    private int triedCount = 1;


    public BridgeGame(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridge = init(bridgeMaker);
    }


    private Bridge init(BridgeMaker bridgeMaker) {
        try {
            outputView.printInitialMessage();
            outputView.printAskBridgeLength();
            int size = inputView.readBridgeSize();
            return new Bridge(bridgeMaker.makeBridge(size));
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return init(bridgeMaker);
        }
    }

    public void play() {
        Visited visited = new Visited();
        ControllerCommand playerChoice = ControllerCommand.RETRY;
        while (bridge.isRemained(visited)) {
            move(visited);
        }
        if (bridge.result(visited) != GameSuccessCondition.SUCCESS) {
            playerChoice = askRetry();
            if (playerChoice == ControllerCommand.RETRY) {
                retry();
            }
        }
        finish(visited);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void move(Visited visited) {
        Moving moving = askMoving();
        visited.move(moving);
        outputView.printMap(bridge, visited);
    }

    private Moving askMoving() {
        try {
            outputView.printMoving();
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return askMoving();
        }
    }

    private ControllerCommand askRetry() {
        try {
            outputView.printAskRetry();
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return askRetry();
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void retry() {
        triedCount++;
        play();
    }

    private void finish(Visited visited) {
        GameSuccessCondition result = bridge.result(visited);
        outputView.printResult(new BridgeGameResultDto(result, triedCount, visited.printVisited(bridge)));
    }
}
