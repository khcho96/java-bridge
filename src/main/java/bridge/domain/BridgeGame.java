package bridge.domain;

import bridge.dto.FinalResultDto;
import bridge.dto.ResultDto;
import bridge.generater.BridgeMaker;
import bridge.generater.BridgeRandomNumberGenerator;
import bridge.constant.MovingResult;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Bridge bridge;
    private int tryCount;
    private Result result;

    public BridgeGame(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        tryCount = 1;
        result = new Result();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MovingResult move(String moving) {
        if (bridge.isSuccessMoving(moving)) {
            if (bridge.isLastMoving()) {
                result.updateState(moving, MovingResult.SUCCESS);
                return MovingResult.WIN;
            }
            result.updateState(moving, MovingResult.SUCCESS);
            return MovingResult.SUCCESS;
        }

        result.updateState(moving, MovingResult.FAIL);
        return MovingResult.FAIL;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        bridge.resetPosition();
        result = new Result();
    }

    public ResultDto getResult() {
        return result.getResult();
    }

    public FinalResultDto getFinalResult() {
        return result.getFinalResult(tryCount);
    }
}
