package bridge.adapter.in.client;

import bridge.application.port.in.BridgeGameUseCase;
import bridge.application.port.in.CreateBridgeCommand;

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
        printStartMessage();
        repeat(this::setUpBridgeGame);
//        play();
//        printResult();
    }


    private void setUpBridgeGame() {
        CreateBridgeCommand createBridgeCommand = inputView.readBridgeSize();
        bridgeGameUseCase.createBridge(createBridgeCommand);
    }

    private void printStartMessage() {
        outputView.printStartMessage();
    }


    private void repeat(Runnable inputReader) {
        try {
            inputReader.run();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            repeat(inputReader);
        }
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
