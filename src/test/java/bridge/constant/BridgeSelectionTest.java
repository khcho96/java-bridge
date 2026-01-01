package bridge.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BridgeSelectionTest {

    @Test
    void 다리_선택_오류() {
        assertThatThrownBy(() -> BridgeSelection.fromName("업"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_BRIDGE_SELECTION.getErrorMessage());
    }

    @Test
    void 위_다리_선택() {
        BridgeSelection bridgeSelection = BridgeSelection.fromName("U");
        assertThat(bridgeSelection).isEqualTo(BridgeSelection.UP);
    }

    @Test
    void 아래_다리_선택() {
        BridgeSelection bridgeSelection = BridgeSelection.fromName("D");
        assertThat(bridgeSelection).isEqualTo(BridgeSelection.DOWN);
    }

    @Test
    void 다리_생성_오류() {
        assertThatThrownBy(() -> BridgeSelection.fromIndex(3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_INDEX.getErrorMessage());
    }

    @Test
    void 위_다리_생성() {
        BridgeSelection bridgeSelection = BridgeSelection.fromIndex(1);
        assertThat(bridgeSelection).isEqualTo(BridgeSelection.UP);
    }

    @Test
    void 아래_다리_생성() {
        BridgeSelection bridgeSelection = BridgeSelection.fromIndex(0);
        assertThat(bridgeSelection).isEqualTo(BridgeSelection.DOWN);
    }
}