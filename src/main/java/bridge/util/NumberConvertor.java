package bridge.util;

import bridge.constant.ErrorMessage;

public final class NumberConvertor {

    public static Integer convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_ERROR.getErrorMessage());
        }
    }
}
