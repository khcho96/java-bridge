package bridge.service;

import bridge.generator.domain.BridgeGame;

public class BridgeService {

    private BridgeGame bridgeGame;

    public void makeBridge(int bridgeSize) {
        bridgeGame = BridgeGame.from(bridgeSize);
    }

    // 도메인 객체 인스턴스 변수로 저장

    // 메서드
}
