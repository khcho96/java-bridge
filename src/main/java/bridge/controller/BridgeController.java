package bridge.controller;

import bridge.service.BridgeService;
import bridge.view.OutputView;

public class BridgeController {

    private final BridgeService bridgeService;

    public BridgeController(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
    }

    public void run() {
        OutputView.printStart();


    }
}

