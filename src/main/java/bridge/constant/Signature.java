package bridge.constant;

import java.util.Arrays;

public enum Signature {

    SUCCESS("O", true),
    FAILURE("X", false),
    NONE(" ", null),
    ;

    private final String name;
    private final Boolean res;

    Signature(String name, Boolean res) {
        this.name = name;
        this.res = res;
    }

    public static Signature from(Boolean res) {
        return Arrays.stream(values())
                .filter(signature -> signature.res == res)
                .findFirst()
                .orElse(NONE);
    }

    public String getName() {
        return name;
    }
}
