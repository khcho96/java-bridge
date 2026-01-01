package bridge.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    void 재시도_선택_오류() {
        assertThatThrownBy(() -> Menu.fromName("재시도"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_MENU_SELECTION.getErrorMessage());
    }

    @Test
    void 재시도_선택_R() {
        Menu menu = Menu.fromName("R");
        assertThat(menu).isEqualTo(Menu.RETRY);
    }

    @Test
    void 재시도_선택_Q() {
        Menu menu = Menu.fromName("Q");
        assertThat(menu).isEqualTo(Menu.QUIT);
    }
}