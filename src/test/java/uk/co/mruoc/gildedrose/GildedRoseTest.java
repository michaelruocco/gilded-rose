package uk.co.mruoc.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void qualityOfANormalItemShouldNeverBeNegative() {
        Item item = new Item("normal-item", 0, 0);
        GildedRose app = new GildedRose(toArray(item));

        app.updateQuality();

        assertThat(item.quality).isZero();
    }

    private static Item[] toArray(Item item) {
        return new Item[] { item };
    }

}
