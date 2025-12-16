package bridge;

import bridge.constant.Constant;
import bridge.constant.MovingResult;
import bridge.domain.BridgeGame;
import bridge.dto.ResultDto;
import bridge.util.InputParser;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printStart();
        String readBridgeSize = InputView.readBridgeSize();
        int bridgeSize = InputParser.parseToInteger(readBridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);

        while (true) {
            String readMoving = InputView.readMoving();
            String moving = InputParser.parseMoving(readMoving);

            MovingResult movingResult = bridgeGame.move(moving);

            if (movingResult == MovingResult.SUCCESS) {
                ResultDto resultDto = bridgeGame.getResult();
                OutputView.printMap(resultDto);
                continue;
            }


        }
    }
}
