package bridge.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberConvertorTest {

    @Test
    void 숫자_변환() {
        Integer number = NumberConvertor.convertToNumber("3");
        assertThat(number).isEqualTo(3);
    }
}