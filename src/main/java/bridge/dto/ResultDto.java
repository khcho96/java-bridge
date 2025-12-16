package bridge.dto;

import java.util.ArrayList;
import java.util.List;

public class ResultDto {

    private final List<String> upBridge;
    private final List<String> downBridge;

    public ResultDto(List<String> up, List<String> down) {
        this.upBridge = new ArrayList<>(up);
        this.downBridge = new ArrayList<>(down);
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }
}
