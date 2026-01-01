package bridge.util;

import bridge.constant.BridgeSelection;
import bridge.constant.Menu;

public final class InputParser {

    private InputParser() {
    }

    public static int parseBridgeSize(String rawBridgeSize) {
        rawBridgeSize = rawBridgeSize.strip();

        Validator.validateBridgeSizeFormat(rawBridgeSize);

        return NumberConvertor.convertToNumber(rawBridgeSize);
    }

    public static BridgeSelection parseMoving(String readMoving) {
        readMoving = readMoving.strip();

        return BridgeSelection.fromName(readMoving);
    }

    public static Menu parseGameCommand(String command) {
        command = command.strip();

        return Menu.fromName(command);
    }
}
