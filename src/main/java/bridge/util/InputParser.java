package bridge.util;

public final class InputParser {

    private static final String DELIMITER = ",";
    private static final String FIRST_DELIMITER = ",";
    private static final String SECOND_DELIMITER = "-";

    private InputParser() {}

    public static Integer parseToInteger(String rawInput) {
        int size =  NumberConvertor.convertToNumber(rawInput.strip());
        Validator.validateBridgeSize(size);

        return size;
    }

    public static String parseMoving(String readMoving) {
        String moving = readMoving.strip();
        Validator.validateMoving(moving);
        return moving;
    }
}
