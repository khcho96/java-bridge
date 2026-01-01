package bridge.controller;

import bridge.constant.BridgeSelection;
import bridge.constant.Menu;
import bridge.constant.Result;
import bridge.generator.domain.GameResult;
import bridge.service.BridgeService;
import bridge.util.InputParser;
import bridge.util.Retry;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final BridgeService bridgeService;

    public BridgeController(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
    }

    public void run() {
        OutputView.printStart();
        makeBridge();

        GameResult gameResult;
        while (true) {
            gameResult = startGame();
            if (gameResult.result().equals(Result.SUCCESS)) {
                break;
            }

            Menu menu = getMenu();
            if (menu.equals(Menu.QUIT)) {
                break;
            }
            bridgeService.retry();
        }

        OutputView.printResult(gameResult);
    }

    private static Menu getMenu() {
        return Retry.retryUntilSuccess(() -> {
            String command = InputView.readGameCommand();
            return InputParser.parseGameCommand(command);
        });
    }

    private GameResult startGame() {
        while (!bridgeService.gameOver()) {
            Retry.retryUntilSuccess(() -> {
                String readMoving = InputView.readMoving();
                BridgeSelection moving = InputParser.parseMoving(readMoving);
                bridgeService.move(moving);
            });
            OutputView.printMap(bridgeService.getResult());
        }
        return bridgeService.getResult();
    }

    private void makeBridge() {
        Retry.retryUntilSuccess(() -> {
            String readBridgeSize = InputView.readBridgeSize();
            int bridgeSize = InputParser.parseBridgeSize(readBridgeSize);
            bridgeService.makeBridge(bridgeSize);
        });
    }
}

