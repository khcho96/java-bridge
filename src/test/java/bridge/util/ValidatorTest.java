package bridge.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constant.ErrorMessage;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void validateBridgeSizeFormat은_숫자만_있으면_통과한다() {
        Validator.validateBridgeSizeFormat("123");
    }

    @Test
    void validateBridgeSizeFormat은_숫자가_아니면_예외를_던진다() {
        assertThatThrownBy(() -> Validator.validateBridgeSizeFormat("12a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BRIDGE_SIZE_ERROR.getErrorMessage());
    }

    @Test
    void validateBridgeSizeFormat은_빈문자열이면_예외를_던진다() {
        assertThatThrownBy(() -> Validator.validateBridgeSizeFormat(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BRIDGE_SIZE_ERROR.getErrorMessage());
    }
}