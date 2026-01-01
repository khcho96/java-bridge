package bridge.domain.dto;

import bridge.constant.Result;
import bridge.domain.GameState;

public final class GameResult {
    private final GameState gameState;
    private final Result result;

    public GameResult(GameState gameState, Result result) {
        this.gameState = gameState;
        this.result = result;
    }

    public GameState gameState() {
        return gameState;
    }

    public Result result() {
        return result;
    }
}
