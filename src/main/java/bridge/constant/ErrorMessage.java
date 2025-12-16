package bridge.constant;

public enum ErrorMessage {

    BRIDGE_SIZE_ERROR("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    _ERROR(""),
    ;

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(Object... args) {
        return ERROR_MESSAGE_PREFIX + String.format(errorMessage, args);
    }

}
