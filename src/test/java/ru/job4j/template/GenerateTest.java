package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled
class GenerateTest {

    @Test
    void whenProduceIsSuccessful() {
        Generator generator = new Generate();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = Map.of("name", "Petr Arsentev", "subject", "you");
        String rsl = "I am a Petr Arsentev, Who are you? ";
        assertThat(generator.produce(template, args)).isEqualTo(rsl);
    }

    @Test
    void whenTemplateIsContainingExcessiveKeysThenGetException() {
        Generator generator = new Generate();
        String template = "I am a ${name} ${surname}, Who are ${subject}? ";
        Map<String, String> args = Map.of("name", "Petr Arsentev", "subject", "you");
        assertThrows(IllegalArgumentException.class, () -> {
            generator.produce(template, args);
        });
    }

    @Test
    void whenMapIsContainingNotExistingKeysThenGetException() {
        Generator generator = new Generate();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = Map.of("name", "Petr Arsentev", "subject", "you",
                "surname", "Arsentev");
        assertThrows(IllegalArgumentException.class, () -> {
            generator.produce(template, args);
        });
    }
}