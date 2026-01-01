package bridge.constant;

public enum ErrorMessage {

    BRIDGE_SIZE_ERROR("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_INDEX("다리 생성에서 오류가 발생했습니다."),
    INVALID_BRIDGE_SELECTION("U 또는 D를 입력하세요."),
    INVALID_MENU_SELECTION("R 또는 Q를 입력하세요."),
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
