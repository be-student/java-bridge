package bridge.adapter.in.client;

import bridge.application.port.in.BridgeGameUseCase;

public class BridgeGameClient {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGameUseCase bridgeGameUseCase;

    public BridgeGameClient(
            InputView inputView,
            OutputView outputView,
            BridgeGameUseCase bridgeGameUseCase
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGameUseCase = bridgeGameUseCase;
    }

    public void playBridgeGame() {
    }
}
