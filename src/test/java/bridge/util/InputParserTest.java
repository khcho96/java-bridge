package bridge.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constant.BridgeSelection;
import bridge.constant.ErrorMessage;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    void 다리_크기_파싱() {
        int bridgeSize = InputParser.parseBridgeSize(" 3 ");
        assertThat(bridgeSize).isEqualTo(3);
    }

    @Test
    void 다리_크기_오류() {
        assertThatThrownBy(() -> InputParser.parseBridgeSize("U"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.BRIDGE_SIZE_ERROR.getErrorMessage());
    }

    @Test
    void 이동할_칸_파싱_U() {
        BridgeSelection moving = InputParser.parseMoving(" U ");
        assertThat(moving).isEqualTo(BridgeSelection.UP);
    }

    @Test
    void 이동할_칸_파싱_D() {
        BridgeSelection moving = InputParser.parseMoving(" D");
        assertThat(moving).isEqualTo(BridgeSelection.DOWN);
    }
}