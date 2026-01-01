package bridge.controller;

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


    }

    private void makeBridge() {
        Retry.retryUntilSuccess(() -> {
            String readBridgeSize = InputView.readBridgeSize();
            int bridgeSize = InputParser.parseBridgeSize(readBridgeSize);
            bridgeService.makeBridge(bridgeSize);
        });
    }
}

