package uk.co.mruoc.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemReportGeneratorTest {

    private final ItemReportGenerator formatter = new ItemReportGenerator();

    @Test
    void shouldGenerateReport() {
        int day = 3;
        Item item1 = new Item("item-1", 1, 2);
        Item item2 = new Item("item-2", 3, 4);

        String formatted = formatter.generate(day, toArray(item1, item2));

        assertThat(formatted).isEqualTo("""
                -------- day 3 --------
                name, sellIn, quality
                item-1, 1, 2
                item-2, 3, 4
                """);
    }

    private static Item[] toArray(Item... items) {
        return items;
    }

}
