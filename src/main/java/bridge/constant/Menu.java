package bridge.constant;

import java.util.Arrays;

public enum Menu {

    RETRY("R"),
    QUIT("Q"),
    ;

    private final String name;

    Menu(String name) {
        this.name = name;
    }

    public static Menu fromName(String name) {
        return Arrays.stream(values())
                .filter(menu -> menu.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_MENU_SELECTION.getErrorMessage()));
    }
}
