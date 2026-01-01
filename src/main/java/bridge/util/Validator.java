package bridge.util;

import bridge.constant.ErrorMessage;

public final class Validator {

    private static final String NUMBER_FORMAT = "^\\d+$";

    private Validator() {}

    public static void validateBridgeSizeFormat(String rawBridgeSize) {
        if (!rawBridgeSize.matches(NUMBER_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_ERROR.getErrorMessage());
        }
    }
}
