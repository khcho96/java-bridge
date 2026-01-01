package bridge.domain;

import bridge.constant.BridgeSelection;

public final class GameState {

    private final BridgeResult bridgeResult;
    private final TryCount tryCount;

    public GameState(BridgeResult bridgeResult, TryCount tryCount) {
        this.bridgeResult = bridgeResult;
        this.tryCount = tryCount;
    }

    public static GameState from(int size) {
        BridgeResult bridgeResult = BridgeResult.from(size);
        TryCount tryCount = TryCount.newInstance();
        return new GameState(bridgeResult, tryCount);
    }

    public boolean isSuccess() {
        return bridgeResult.isSuccess();
    }

    public boolean gameOver() {
        return bridgeResult.gameOver();
    }

    public void setSuccess(BridgeSelection moving) {
        bridgeResult.setSuccess(moving);
    }

    public void setFailure(BridgeSelection moving) {
        bridgeResult.setFailure(moving);
    }

    public void retry() {
        bridgeResult.retry();
        tryCount.increaseTryCount();
    }

    public BridgeResult bridgeResult() {
        return bridgeResult;
    }

    public TryCount tryCount() {
        return tryCount;
    }
}
