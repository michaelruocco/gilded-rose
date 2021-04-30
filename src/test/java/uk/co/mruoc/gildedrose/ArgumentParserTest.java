package uk.co.mruoc.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class ArgumentParserTest {

    private final ArgumentParser parser = new ArgumentParser();

    @Test
    void shouldReturnTwoDaysIfArgsIsEmpty() {
        String[] args = new String[0];

        int days = parser.toDays(args);

        assertThat(days).isEqualTo(2);
    }

    @Test
    void shouldReturnIntValueFromFirstArgumentPlusOne() {
        String[] args = new String[] {"5"};

        int days = parser.toDays(args);

        assertThat(days).isEqualTo(6);
    }

    @Test
    void shouldThrowExceptionIfFirstArgumentIsNotAnInt() {
        String[] args = new String[] {"invalid"};

        Throwable error = catchThrowable(() -> parser.toDays(args));

        assertThat(error)
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("For input string: \"invalid\"");
    }

}
