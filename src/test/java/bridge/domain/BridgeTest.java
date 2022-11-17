package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Bridge 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BridgeTest {
    private static final Bridge bridge = new Bridge(List.of("U", "D", "D"));

    @Test
    void isRemained_메서드는_bridge에_더_진행_가능한지_여부를_반환한다() {
        Visited visited = new Visited();
        visited.move(Moving.UP);
        assertThat(bridge.isRemained(visited)).isTrue();

        visited.move(Moving.UP);
        assertThat(bridge.isRemained(visited)).isFalse();
    }

    @Test
    void result_메서드는_visited_에_따라_적절한_GameSuccessCondition_을_반환한다() {
        Visited visited = new Visited();
        assertThat(bridge.result(visited)).isEqualTo(GameSuccessCondition.FAILURE);

        visited.move(Moving.UP);
        assertThat(bridge.result(visited)).isEqualTo(GameSuccessCondition.FAILURE);

        visited.move(Moving.DOWN);
        assertThat(bridge.result(visited)).isEqualTo(GameSuccessCondition.FAILURE);

        visited.move(Moving.DOWN);
        assertThat(bridge.result(visited)).isEqualTo(GameSuccessCondition.SUCCESS);
    }
}
