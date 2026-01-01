package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.constant.BridgeSelection;
import org.junit.jupiter.api.Test;

class BridgeResultTest {

    @Test
    void 성공으로_게임_종료_확인() {
        BridgeResult bridgeResult = BridgeResult.from(3);

        bridgeResult.setSuccess(BridgeSelection.UP);
        bridgeResult.setSuccess(BridgeSelection.DOWN);
        bridgeResult.setSuccess(BridgeSelection.DOWN);

        assertThat(bridgeResult.gameOver()).isTrue();
    }

    @Test
    void 실패로_게임_종료_확인() {
        BridgeResult bridgeResult = BridgeResult.from(3);

        bridgeResult.setSuccess(BridgeSelection.UP);
        bridgeResult.setFailure(BridgeSelection.DOWN);

        assertThat(bridgeResult.gameOver()).isTrue();
    }

    @Test
    void 성공인지_확인() {
        BridgeResult bridgeResult = BridgeResult.from(3);

        bridgeResult.setSuccess(BridgeSelection.UP);

        assertThat(bridgeResult.isSuccess()).isTrue();
    }

    @Test
    void 실패인지_확인() {
        BridgeResult bridgeResult = BridgeResult.from(3);

        bridgeResult.setFailure(BridgeSelection.UP);

        assertThat(bridgeResult.isSuccess()).isFalse();
    }

    @Test
    void 재시도() {
        BridgeResult bridgeResult = BridgeResult.from(3);

        bridgeResult.setSuccess(BridgeSelection.UP);
        bridgeResult.setFailure(BridgeSelection.UP);

        assertThat(bridgeResult.isSuccess()).isFalse();

        bridgeResult.retry();

        assertThat(bridgeResult.getResult()).isEmpty();
        assertThat(bridgeResult.getBridgeSelections()).isEmpty();
    }
}