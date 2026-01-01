package bridge.domain;

import bridge.constant.BridgeSelection;
import bridge.constant.ErrorMessage;
import bridge.generator.BridgeMaker;
import bridge.generator.BridgeRandomNumberGenerator;
import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private final List<BridgeSelection> bridge;
    private int index;

    private Bridge(List<BridgeSelection> bridge) {
        validateSize(bridge);
        this.bridge = bridge;
    }

    public static Bridge from(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> rawBridge = bridgeMaker.makeBridge(size);
        List<BridgeSelection> bridge = rawBridge.stream()
                .map(BridgeSelection::fromName)
                .collect(Collectors.toList());
        return new Bridge(bridge);
    }

    private void validateSize(List<BridgeSelection> bridge) {
        if (bridge.size() < MIN_SIZE || bridge.size() > MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_ERROR.getErrorMessage());
        }
    }

    public BridgeSelection next() {
        return bridge.get(index++);
    }

    public void retry() {
        index = 0;
    }
}
