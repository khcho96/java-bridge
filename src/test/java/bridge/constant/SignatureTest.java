package bridge.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SignatureTest {

    @Test
    void 성공() {
        Signature signature = Signature.from(true);
        assertThat(signature).isEqualTo(Signature.SUCCESS);
    }

    @Test
    void 실패() {
        Signature signature = Signature.from(false);
        assertThat(signature).isEqualTo(Signature.FAILURE);
    }
}