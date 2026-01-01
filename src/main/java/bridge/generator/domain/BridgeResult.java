package bridge.generator.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {

    private final List<Boolean> result;

    private BridgeResult() {
        this.result = new ArrayList<>();
    }

    public static BridgeResult newInstance() {
        return new BridgeResult();
    }

    public void reset() {
        result.clear();
    }
}
