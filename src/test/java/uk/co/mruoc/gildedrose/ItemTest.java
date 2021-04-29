package uk.co.mruoc.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    void itemShouldPrintNameSellInAndQuality() {
        Item item = new Item("My Item", 1, 2);

        String output = item.toString();

        assertThat(output).isEqualTo("My Item, 1, 2");
    }

}
