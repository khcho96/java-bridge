package bridge.domain;

import bridge.constant.BridgeSelection;
import bridge.constant.Result;
import bridge.domain.dto.GameResult;

public class BridgeGame {

    private final Bridge bridge;
    private final GameState gameState;

    public BridgeGame(Bridge bridge, GameState gameState) {
        this.bridge = bridge;
        this.gameState = gameState;
    }

    public static BridgeGame from(int size) {
        Bridge bridge = Bridge.from(size);
        GameState gameState = GameState.from(size);
        return new BridgeGame(bridge, gameState);
    }

    public void move(BridgeSelection moving) {
        if (bridge.next() == moving) {
            gameState.setSuccess(moving);
            return;
        }

        gameState.setFailure(moving);
    }

    public void retry() {
        bridge.retry();
        gameState.retry();
    }

    public GameResult getResult() {
        Result result = Result.from(gameState.isSuccess());
        return new GameResult(gameState, result);
    }

    public boolean gameOver() {
        return gameState.gameOver();
    }
}
