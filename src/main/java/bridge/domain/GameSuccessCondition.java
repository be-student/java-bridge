package bridge.domain;

public enum GameSuccessCondition {
    SUCCESS("성공"),
    FAILURE("실패");

    private final String gameCondition;

    GameSuccessCondition(String gameCondition) {
        this.gameCondition = gameCondition;
    }

    public static GameSuccessCondition from(boolean hasDifferent) {
        if (hasDifferent == false) {
            return GameSuccessCondition.FAILURE;
        }
        return GameSuccessCondition.SUCCESS;
    }

    public String gameResultMessage() {
        return this.gameCondition;
    }
}
