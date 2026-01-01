package bridge.generator.domain;

import bridge.constant.BridgeSelection;
import java.util.ArrayList;
import java.util.List;

public class BridgeResult {

    private final List<Boolean> result;
    private final List<BridgeSelection> bridgeSelections;
    private final int size;

    private BridgeResult(int size) {
        this.result = new ArrayList<>();
        this.bridgeSelections = new ArrayList<>();
        this.size = size;
    }

    public static BridgeResult from(int size) {
        return new BridgeResult(size);
    }

    public void retry() {
        result.clear();
        bridgeSelections.clear();
    }

    public boolean isSuccess() {
        if (!result.isEmpty()) {
            return result.getLast();
        }
        return false;
    }

    public boolean gameOver() {
        if (!result.isEmpty()) {
            return result.size() == size || result.getLast() == false;
        }
        return false;
    }

    public void setSuccess(BridgeSelection moving) {
        result.add(true);
        bridgeSelections.add(moving);
    }

    public void setFailure(BridgeSelection moving) {
        result.add(false);
        bridgeSelections.add(moving);
    }

    public List<Boolean> getResult() {
        return result;
    }

    public List<BridgeSelection> getBridgeSelections() {
        return bridgeSelections;
    }
}
