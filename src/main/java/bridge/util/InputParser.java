package bridge.util;

import static bridge.constant.ErrorMessage.BRIDGE_SIZE_ERROR;

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
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR.getErrorMessage());
        }

        return size;
    }

    public static List<Integer> parseToElements1(String rawInput) {
        Validator.validateNullOrBlank(rawInput);
        rawInput = rawInput.strip();

        Validator.validateCsvFormat(rawInput);

        return Stream.of(rawInput.split(DELIMITER))
                .map(String::strip)
                .map(NumberConvertor::convertToNumber)
                .toList();
    }

    public static List<String> parseToElements2(String rawInput) {
        Validator.validateOrder(rawInput);
        rawInput = rawInput.strip();

        List<String> orderMenus = new ArrayList<>();
        String[] split = rawInput.split(FIRST_DELIMITER);
        for (String s : split) {
            String[] order = s.strip().split(SECOND_DELIMITER);
            String name = order[0];
            int count = NumberConvertor.convertToNumber(order[1]);

            for (int i = 0; i < count; i++) {
                orderMenus.add(name);
            }
        }

        return orderMenus;
    }
}
