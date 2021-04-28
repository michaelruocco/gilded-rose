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

    @Test
    void qualityOfANormalShouldDegradeTwiceAsFastAfterSellByDate() {
        Item item = new Item("normal-item", 1, 10);
        GildedRose app = new GildedRose(toArray(item));

        app.updateQuality();

        assertThat(item.sellIn).isZero();
        assertThat(item.quality).isEqualTo(9);

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(7);
    }

    private static Item[] toArray(Item item) {
        return new Item[] { item };
    }

}
