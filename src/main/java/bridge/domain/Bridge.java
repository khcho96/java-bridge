package bridge.domain;

import java.util.List;

public class Bridge {

    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isSuccessStep(String step, int index) {
        return false;
    }
}
