package bridge.domain;

public enum GameSuccessCondition {
    SUCCESS("성공"),
    FAILURE("실패");

    private final String gameCondition;

    GameSuccessCondition(String gameCondition) {
        this.gameCondition = gameCondition;
    }

    public String gameResultMessage() {
        return this.gameCondition;
    }
}
