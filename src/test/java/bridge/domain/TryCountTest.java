package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TryCountTest {

    @Test
    void 재시도_횟수_증가() {
        TryCount tryCount = TryCount.newInstance();

        tryCount.increaseTryCount();
        tryCount.increaseTryCount();
        tryCount.increaseTryCount();

        assertThat(tryCount.toString()).isEqualTo("4");
    }
}