package bridge.adapter.in.client;

import bridge.application.port.in.BridgeGameUseCase;
import java.util.function.Supplier;

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


    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(inputReader);
        }
    }
}
