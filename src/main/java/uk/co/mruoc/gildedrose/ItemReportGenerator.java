package uk.co.mruoc.gildedrose;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ItemReportGenerator {

    private static final String TEMPLATE = """
            -------- day %d --------
            name, sellIn, quality
            %s
            """;

    public String generate(int day, Item[] items) {
        return String.format(TEMPLATE, day, toString(items));
    }

    private static String toString(Item[] items) {
        return Arrays.stream(items)
                .map(Item::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

}
