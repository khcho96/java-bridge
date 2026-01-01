package bridge.constant;

import java.util.Arrays;

public enum BridgeSelection {

    DOWN(0, "D"),
    UP(1, "U"),
    ;

    private final int index;
    private final String name;

    BridgeSelection(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public static BridgeSelection fromIndex(int index) {
        return Arrays.stream(values())
                .filter(bridgeSelection -> bridgeSelection.index == index)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INDEX.getErrorMessage()));
    }

    public static BridgeSelection fromName(String name) {
        return Arrays.stream(values())
                .filter(bridgeSelection -> bridgeSelection.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SELECTION.getErrorMessage()));
    }

    public String getName() {
        return name;
    }
}
