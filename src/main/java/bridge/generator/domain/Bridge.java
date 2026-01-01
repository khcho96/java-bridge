package bridge.generator.domain;

import bridge.constant.BridgeSelection;
import bridge.constant.ErrorMessage;
import bridge.generator.BridgeMaker;
import bridge.generator.BridgeRandomNumberGenerator;
import java.util.List;

public class Bridge {

    private final List<BridgeSelection> bridge;

    private Bridge(List<BridgeSelection> bridge) {
        validateSize(bridge);
        this.bridge = bridge;
    }

    public static Bridge from(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> rawBridge = bridgeMaker.makeBridge(size);
        List<BridgeSelection> bridge = rawBridge.stream()
                .map(BridgeSelection::fromName)
                .toList();
        return new Bridge(bridge);
    }

    private void validateSize(List<BridgeSelection> bridge) {
        if (bridge.size() < 3 || bridge.size() > 20) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_ERROR.getErrorMessage());
        }
    }
}
