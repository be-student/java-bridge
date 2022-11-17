package bridge.dto;

import bridge.domain.GameSuccessCondition;

public class BridgeGameResultDto {
    private final String successOrFailure;
    private final int triedCount;
    private final String finalResult;

    public BridgeGameResultDto(GameSuccessCondition successOrFailure, int triedCount, String finalResult) {
        this.successOrFailure = successOrFailure.gameResultMessage();
        this.triedCount = triedCount;
        this.finalResult = finalResult;
    }

    public int getTriedCount() {
        return triedCount;
    }

    public String getSuccessOrFailure() {
        return successOrFailure;
    }

    public String getFinalResult() {
        return finalResult;
    }
}
