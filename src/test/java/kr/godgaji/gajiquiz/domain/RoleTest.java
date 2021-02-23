package kr.godgaji.gajiquiz.domain;

import kr.godgaji.gajiquiz.domain.Member.Role;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoleTest {

    @DisplayName("name으로 Role 찾기")
    @Test
    public void valueOfName() {
        String admin = Role.ADMIN.getName();
        String user = Role.USER.getName();

        assertThat(Role.valueOfName(admin)).isEqualTo(Role.ADMIN);
        assertThat(Role.valueOfName(user)).isEqualTo(Role.USER);
    }
}
