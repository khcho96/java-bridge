package bridge.util;

public final class InputParser {

    private InputParser() {
    }

    public static int parseBridgeSize(String rawBridgeSize) {
        rawBridgeSize = rawBridgeSize.strip();

        Validator.validateBridgeSizeFormat(rawBridgeSize);

        return NumberConvertor.convertToNumber(rawBridgeSize);
    }
}
