package bridge.service;

import bridge.constant.BridgeSelection;
import bridge.domain.BridgeGame;
import bridge.domain.GameResult;

public class BridgeService {

    private BridgeGame bridgeGame;

    public void makeBridge(int bridgeSize) {
        bridgeGame = BridgeGame.from(bridgeSize);
    }

    public boolean gameOver() {
        return bridgeGame.gameOver();
    }

    public void move(BridgeSelection moving) {
        bridgeGame.move(moving);
    }

    public GameResult getResult() {
        return bridgeGame.getResult();
    }

    public void retry() {
        bridgeGame.retry();
    }
}
