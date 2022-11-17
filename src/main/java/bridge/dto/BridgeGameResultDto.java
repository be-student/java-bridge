package bridge.dto;

import bridge.domain.GameSuccessCondition;

public class BridgeGameResultDto {
    private final GameSuccessCondition successOrFailure;
    private final int triedCount;

    public BridgeGameResultDto(GameSuccessCondition successOrFailure, int triedCount) {
        this.successOrFailure = successOrFailure;
        this.triedCount = triedCount;
    }

    public int getTriedCount() {
        return triedCount;
    }

    public GameSuccessCondition getSuccessOrFailure() {
        return successOrFailure;
    }
}
