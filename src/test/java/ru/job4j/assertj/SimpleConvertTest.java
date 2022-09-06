package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;
import java.util.Set;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .contains("five")
                .contains("five", Index.atIndex(4))
                .containsAnyOf("zero", "five", "six")
                .doesNotContain("first", Index.atIndex(3))
                .element(4).isEqualTo("five")
                .doesNotHaveToString("six")
                .isNotNull()
                .isNotEqualTo("seven")
                .isEqualTo("five")
                .hasToString("five");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set).hasSize(5)
                .doesNotContain("six")
                .contains("three")
                .containsAnyOf("zero", "second", "six")
                .containsExactlyInAnyOrder("second", "first", "five", "three", "four")
                .element(2).isNotNull()
                .doesNotHaveToString("seven")
                .hasToString("five")
                .isSameAs("five");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).hasSize(5)
                .containsKeys("second", "three", "five")
                .doesNotContainKey("six")
                .isNotEmpty()
                .hasFieldOrProperty("five")
                .isNotEqualTo("seven")
                .doesNotHaveToString("seven")
                .hasSizeBetween(4, 6)
                .hasSizeGreaterThan(4)
                .hasSizeLessThan(6)
                .hasSizeLessThanOrEqualTo(5);
    }
}