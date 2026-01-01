package bridge.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void 성공() {
        Result result = Result.from(true);
        assertThat(result).isEqualTo(Result.SUCCESS);
    }

    @Test
    void 실패() {
        Result result = Result.from(false);
        assertThat(result).isEqualTo(Result.FAILURE);
    }
}