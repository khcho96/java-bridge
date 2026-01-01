package bridge.generator.domain;

public class GameState {

    private final BridgeResult bridgeResult;
    private final TryCount tryCount;

    public GameState(BridgeResult bridgeResult, TryCount tryCount) {
        this.bridgeResult = bridgeResult;
        this.tryCount = tryCount;
    }

    public static GameState newInstance() {
        BridgeResult bridgeResult = BridgeResult.newInstance();
        TryCount tryCount = TryCount.newInstance();
        return new GameState(bridgeResult, tryCount);
    }

    public BridgeResult getBridgeResult() {
        return bridgeResult;
    }

    public TryCount getTryCount() {
        return tryCount;
    }
}
