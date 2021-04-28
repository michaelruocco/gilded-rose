package uk.co.mruoc.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void qualityOfNormalItemShouldNeverBeNegative() {
        Item item = new Item("normal-item", 0, 0);
        GildedRose app = new GildedRose(toArray(item));

        app.updateQuality();

        assertThat(item.quality).isZero();
    }

    @Test
    void qualityOfNormalItemShouldDegradeTwiceAsFastAfterSellByDate() {
        Item item = new Item("normal-item", 1, 10);
        GildedRose app = new GildedRose(toArray(item));

        app.updateQuality();

        assertThat(item.sellIn).isZero();
        assertThat(item.quality).isEqualTo(9);

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(7);
    }

    @Test
    void qualityOfAgedBrieShouldIncreaseTheOlderItGets() {
        Item item = new Item("Aged Brie", 0, 0);
        GildedRose app = new GildedRose(toArray(item));

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(2);
    }

    private static Item[] toArray(Item item) {
        return new Item[] { item };
    }

}
