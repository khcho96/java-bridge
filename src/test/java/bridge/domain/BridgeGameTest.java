package bridge.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.constant.BridgeSelection;
import bridge.constant.Result;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    void 성공_테스트() {
        assertRandomNumberInRangeTest(() -> {
            BridgeGame bridgeGame = BridgeGame.from(3);
            bridgeGame.move(BridgeSelection.UP);
            bridgeGame.move(BridgeSelection.DOWN);
            bridgeGame.move(BridgeSelection.UP);

            Result result = bridgeGame.getResult().result();

            assertThat(result).isEqualTo(Result.SUCCESS);
        }, 1, 0, 1);
    }

    @Test
    void 실패_테스트() {
        assertRandomNumberInRangeTest(() -> {
            BridgeGame bridgeGame = BridgeGame.from(3);
            bridgeGame.move(BridgeSelection.UP);
            bridgeGame.move(BridgeSelection.DOWN);
            bridgeGame.move(BridgeSelection.DOWN);

            Result result = bridgeGame.getResult().result();

            assertThat(result).isEqualTo(Result.FAILURE);
        }, 1, 0, 1);
    }

    @Test
    void 게임_종료_확인_테스트() {
        assertRandomNumberInRangeTest(() -> {
            BridgeGame bridgeGame = BridgeGame.from(3);
            bridgeGame.move(BridgeSelection.UP);
            bridgeGame.move(BridgeSelection.DOWN);
            bridgeGame.move(BridgeSelection.DOWN);

            assertThat(bridgeGame.gameOver()).isTrue();
        }, 1, 0, 1);
    }

    @Test
    void 게임_미종료_확인_테스트() {
        assertRandomNumberInRangeTest(() -> {
            BridgeGame bridgeGame = BridgeGame.from(3);
            bridgeGame.move(BridgeSelection.UP);
            bridgeGame.move(BridgeSelection.DOWN);

            assertThat(bridgeGame.gameOver()).isFalse();
        }, 1, 0, 1);
    }

    @Test
    void 재시도_횟수_테스트() {
        assertRandomNumberInRangeTest(() -> {
            BridgeGame bridgeGame = BridgeGame.from(3);
            bridgeGame.move(BridgeSelection.UP);
            bridgeGame.move(BridgeSelection.UP);

            assertThat(bridgeGame.getResult().gameState().tryCount().toString()).isEqualTo("1");

            bridgeGame.retry();

            assertThat(bridgeGame.getResult().gameState().tryCount().toString()).isEqualTo("2");
        }, 1, 0, 1);
    }

    @Test
    void 재시도_테스트() {
        assertRandomNumberInRangeTest(() -> {
            BridgeGame bridgeGame = BridgeGame.from(3);
            bridgeGame.move(BridgeSelection.UP);
            bridgeGame.move(BridgeSelection.UP);

            assertThat(bridgeGame.getResult().result()).isEqualTo(Result.FAILURE);

            bridgeGame.retry();

            bridgeGame.move(BridgeSelection.UP);
            bridgeGame.move(BridgeSelection.DOWN);
            bridgeGame.move(BridgeSelection.UP);

            assertThat(bridgeGame.getResult().result()).isEqualTo(Result.SUCCESS);
        }, 1, 0, 1);
    }
}