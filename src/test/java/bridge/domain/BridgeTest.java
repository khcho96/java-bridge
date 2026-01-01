package bridge.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constant.BridgeSelection;
import bridge.constant.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    void 다리_크기_오류(int size) {
        assertThatThrownBy(() -> Bridge.from(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BRIDGE_SIZE_ERROR.getErrorMessage());
    }

    @Test
    void 다리_생성_테스트() {
        assertRandomNumberInRangeTest(() -> {
            Bridge bridge = Bridge.from(3);

            assertThat(bridge.next()).isEqualTo(BridgeSelection.UP);
            assertThat(bridge.next()).isEqualTo(BridgeSelection.DOWN);
            assertThat(bridge.next()).isEqualTo(BridgeSelection.UP);
        }, 1, 0, 1);
    }

    @Test
    void 재시도_테스트() {
        assertRandomNumberInRangeTest(() -> {
            Bridge bridge = Bridge.from(3);

            assertThat(bridge.next()).isEqualTo(BridgeSelection.UP);
            assertThat(bridge.next()).isEqualTo(BridgeSelection.DOWN);
            assertThat(bridge.next()).isEqualTo(BridgeSelection.UP);

            bridge.retry();

            assertThat(bridge.next()).isEqualTo(BridgeSelection.UP);
            assertThat(bridge.next()).isEqualTo(BridgeSelection.DOWN);
            assertThat(bridge.next()).isEqualTo(BridgeSelection.UP);
        }, 1, 0, 1);
    }
}
