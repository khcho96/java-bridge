package bridge.domain;

import bridge.constant.Constant;
import bridge.constant.FinalResult;
import bridge.constant.MovingResult;
import bridge.dto.ResultDto;
import java.util.ArrayList;
import java.util.List;

public class Result {

    private List<String> upBridge;
    private List<String> downBridge;
    private FinalResult finalResult;

    public Result() {
        this.upBridge = new ArrayList<>();
        this.downBridge = new ArrayList<>();
    }

    public void updateState(String moving, MovingResult movingResult) {
        if (movingResult.equals(MovingResult.SUCCESS) && moving.equals(Constant.UP)) {
            upBridge.add("O");
            downBridge.add(" ");
            finalResult = FinalResult.WIN;
            return;
        }

        if (movingResult.equals(MovingResult.SUCCESS) && moving.equals(Constant.DOWN)) {
            upBridge.add(" ");
            downBridge.add("O");
            finalResult = FinalResult.WIN;
            return;
        }

        if (movingResult.equals(MovingResult.FAIL) && moving.equals(Constant.UP)) {
            upBridge.add("X");
            downBridge.add(" ");
            finalResult = FinalResult.LOSE;
            return;
        }

        upBridge.add(" ");
        downBridge.add("X");
        finalResult = FinalResult.LOSE;
    }

    public ResultDto getResult(int tryCount) {
        return new ResultDto(upBridge, downBridge, tryCount, finalResult);
    }
}
