package bridge;

import bridge.constant.Constant;
import bridge.constant.MovingResult;
import bridge.domain.BridgeGame;
import bridge.dto.FinalResultDto;
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

            if (movingResult == MovingResult.FAIL) {
                ResultDto result = bridgeGame.getResult();
                OutputView.printMap(result);

                String readGameCommand = InputView.readGameCommand();
                String gameCommand = InputParser.parseGameCommand(readGameCommand);

                if (gameCommand.equals(Constant.RESTART)) {
                    bridgeGame.retry();
                    continue;
                }

                FinalResultDto finalResult = bridgeGame.getFinalResult();
                OutputView.printResult(finalResult);
                break;
            }

            if (movingResult == MovingResult.WIN) {
                FinalResultDto finalResult = bridgeGame.getFinalResult();
                OutputView.printResult(finalResult);
            }
        }
    }
}
