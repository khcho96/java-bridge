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

        int bridgeSize;
        while (true) {
            try {
                String readBridgeSize = InputView.readBridgeSize();
                bridgeSize = InputParser.parseToInteger(readBridgeSize);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);

        while (true) {
            String moving;
            while (true) {
                try {
                    String readMoving = InputView.readMoving();
                    moving = InputParser.parseMoving(readMoving);
                    break;
                } catch (IllegalArgumentException e) {
                    OutputView.printErrorMessage(e);
                }
            }
            MovingResult movingResult = bridgeGame.move(moving);

            if (movingResult == MovingResult.SUCCESS) {
                ResultDto resultDto = bridgeGame.getResult();
                OutputView.printMap(resultDto);
                continue;
            }

            if (movingResult == MovingResult.FAIL) {
                ResultDto result = bridgeGame.getResult();
                OutputView.printMap(result);

                String gameCommand;
                while (true) {
                    try {
                        String readGameCommand = InputView.readGameCommand();
                        gameCommand = InputParser.parseGameCommand(readGameCommand);
                        break;
                    } catch (IllegalArgumentException e) {
                        OutputView.printErrorMessage(e);
                    }
                }

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
                break;
            }
        }
    }
}
