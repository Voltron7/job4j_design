package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {
    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Valeri");
        assertThat(config.value("surname")).isEqualTo("Shpakowski");
    }

    @Test
    void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Valeri");
        assertThat(config.value("surname")).isEqualTo("Shpakowski");
    }

    @Test
    public void whenPairWithEmptyLines() {
        String path = "./data/pair_with_empty_lines.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Valeri");
        assertThat(config.value("surname")).isEqualTo("Shpakowski");
    }

    @Test
    void whenPairWithEmptyLinesAndComment() {
        String path = "./data/pair_with_empty_lines_and_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Valeri");
        assertThat(config.value("surname")).isEqualTo("Shpakowski");
    }

    @Test
    public void whenDoesNotHavePairAtStart() {
        String path = "./data/does_not_have_pair_at_start.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Incorrect properties input.");
    }

    @Test
    public void whenDoesNotHavePairAtEnd() {
        String path = "./data/does_not_have_pair_at_end.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Incorrect properties input.");
    }

    @Test
    public void whenHaveOnlyEqualSymbol() {
        String path = "./data/only_equal_symbol.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Incorrect properties input.");
    }

    @Test
    public void whenDoNotHaveEqualSymbol() {
        String path = "./data/do_not_have_equal_symbol.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Incorrect properties input.");
    }

    @Test
    public void whenEqualSymbolsAtEnd() {
        String path = "./data/equal_symbols_at_end.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Valeri");
        assertThat(config.value("surname")).isEqualTo("Shpakowski=1=");
    }
}