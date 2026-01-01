package bridge.constant;

import java.util.Arrays;

public enum Result {
    SUCCESS(true, "성공"),
    FAILURE(false, "실패"),
    ;

    private final boolean result;
    private final String name;

    Result(boolean result, String name) {
        this.result = result;
        this.name = name;
    }

    public static Result from(boolean res) {
        return Arrays.stream(values())
                .filter(result -> result.result == res)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_MENU_SELECTION.getErrorMessage()));
    }

    public String getName() {
        return name;
    }
}
