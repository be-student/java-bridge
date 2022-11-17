package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Logger 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LoggerTest {
    @Test
    void Logger_클래스는_잘_작동한다() {
        Logger logger = new Logger();
        logger.put(Moving.UP, true);
        assertThat(logger.calculateMap()).isEqualTo("[ O ]\n[   ]");
        logger.put(Moving.UP, true);
        assertThat(logger.calculateMap()).isEqualTo("[ O | O ]\n[   |   ]");
        logger.put(Moving.DOWN, false);
        assertThat(logger.calculateMap()).isEqualTo("[ O | O |   ]\n[   |   | X ]");
    }
}
