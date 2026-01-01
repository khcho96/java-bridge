package bridge.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.constant.BridgeSelection;
import bridge.constant.Result;
import org.junit.jupiter.api.Test;

class BridgeServiceTest {

    @Test
    void 성공() {
        assertRandomNumberInRangeTest(() -> {
            BridgeService bridgeService = new BridgeService();
            bridgeService.makeBridge(3);

            bridgeService.move(BridgeSelection.UP);
            bridgeService.move(BridgeSelection.DOWN);
            bridgeService.move(BridgeSelection.UP);

            assertThat(bridgeService.gameOver()).isTrue();
            assertThat(bridgeService.getResult().result()).isEqualTo(Result.SUCCESS);
        }, 1, 0, 1);
    }

    @Test
    void 실패() {
        assertRandomNumberInRangeTest(() -> {
            BridgeService bridgeService = new BridgeService();
            bridgeService.makeBridge(3);

            bridgeService.move(BridgeSelection.UP);
            bridgeService.move(BridgeSelection.UP);

            assertThat(bridgeService.gameOver()).isTrue();
            assertThat(bridgeService.getResult().result()).isEqualTo(Result.FAILURE);
        }, 1, 0, 1);
    }

    @Test
    void 실패후_재시도_성공() {
        assertRandomNumberInRangeTest(() -> {
            BridgeService bridgeService = new BridgeService();
            bridgeService.makeBridge(3);

            bridgeService.move(BridgeSelection.UP);
            bridgeService.move(BridgeSelection.UP);

            assertThat(bridgeService.gameOver()).isTrue();
            assertThat(bridgeService.getResult().result()).isEqualTo(Result.FAILURE);

            bridgeService.retry();

            bridgeService.move(BridgeSelection.UP);
            bridgeService.move(BridgeSelection.DOWN);
            bridgeService.move(BridgeSelection.UP);

            assertThat(bridgeService.gameOver()).isTrue();
            assertThat(bridgeService.getResult().result()).isEqualTo(Result.SUCCESS);
        }, 1, 0, 1);
    }
}