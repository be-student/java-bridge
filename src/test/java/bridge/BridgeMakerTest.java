package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BridgeMaker 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BridgeMakerTest {
    @Test
    void makeBridge_메서드는_주어진_길이에_따라_다리를_만들어낸다() {
        List<String> result = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(20);
        assertThat(result).hasSize(20);
        int uCount = (int) result.stream().filter(it -> it.equals("U")).count();
        int dCount = (int) result.stream().filter(it -> it.equals("D")).count();
        assertThat(uCount + dCount).isEqualTo(20);
    }
}
