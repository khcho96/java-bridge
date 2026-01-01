package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.constant.BridgeSelection;
import org.junit.jupiter.api.Test;

class GameStateTest {

    @Test
    void 성공() {
        GameState gameState = GameState.from(3);

        gameState.setSuccess(BridgeSelection.UP);
        gameState.setSuccess(BridgeSelection.DOWN);
        gameState.setSuccess(BridgeSelection.UP);

        assertThat(gameState.isSuccess()).isTrue();
    }

    @Test
    void 실패() {
        GameState gameState = GameState.from(3);

        gameState.setSuccess(BridgeSelection.UP);
        gameState.setSuccess(BridgeSelection.DOWN);
        gameState.setFailure(BridgeSelection.DOWN);

        assertThat(gameState.isSuccess()).isFalse();
    }

    @Test
    void 성공_게임_종료_확인() {
        GameState gameState = GameState.from(3);

        gameState.setSuccess(BridgeSelection.UP);
        gameState.setSuccess(BridgeSelection.DOWN);
        gameState.setSuccess(BridgeSelection.UP);

        assertThat(gameState.gameOver()).isTrue();
    }

    @Test
    void 실패_게임_종료_확인() {
        GameState gameState = GameState.from(3);

        gameState.setFailure(BridgeSelection.UP);

        assertThat(gameState.gameOver()).isTrue();
    }

    @Test
    void 재시도_횟수_확인() {
        GameState gameState = GameState.from(3);

        assertThat(gameState.tryCount().toString()).isEqualTo("1");

        gameState.retry();
        gameState.retry();
        gameState.retry();

        assertThat(gameState.tryCount().toString()).isEqualTo("4");
    }

    @Test
    void 재시도_리셋_확인() {
        GameState gameState = GameState.from(3);

        gameState.setSuccess(BridgeSelection.DOWN);

        gameState.retry();

        assertThat(gameState.bridgeResult().getResult()).isEmpty();
    }
}