package bridge.domain;

import bridge.constant.Constant;
import bridge.constant.MovingResult;
import bridge.dto.ResultDto;
import java.util.ArrayList;
import java.util.List;

public class Result {

    private List<String> upBridge;
    private List<String> downBridge;

    public Result() {
        this.upBridge = new ArrayList<>();
        this.downBridge = new ArrayList<>();
    }

    public void updateState(String moving, MovingResult movingResult) {
        if (movingResult.equals(MovingResult.SUCCESS) && moving.equals(Constant.UP)) {
            upBridge.add("O");
            downBridge.add(" ");
            return;
        }

        if (movingResult.equals(MovingResult.SUCCESS) && moving.equals(Constant.DOWN)) {
            upBridge.add(" ");
            downBridge.add("O");
            return;
        }

        if (movingResult.equals(MovingResult.FAIL) && moving.equals(Constant.UP)) {
            upBridge.add("X");
            downBridge.add(" ");
            return;
        }

        upBridge.add(" ");
        downBridge.add("X");
    }

    public ResultDto getResult() {
        return new ResultDto(upBridge, downBridge);
    }
}
