package bridge.util;

import static bridge.constant.ErrorMessage.BRIDGE_SIZE_ERROR;
import static bridge.util.Validator.validateBridgeSize;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class InputParser {

    private static final String DELIMITER = ",";
    private static final String FIRST_DELIMITER = ",";
    private static final String SECOND_DELIMITER = "-";

    private InputParser() {}

    public static Integer parseToInteger(String rawInput) {
        int size =  NumberConvertor.convertToNumber(rawInput.strip());
        validateBridgeSize(size);

        return size;
    }
}
