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

    @Test
    void qualityOfAgedBrieShouldNeverIncreaseAboveFifty() {
        Item item = new Item("Aged Brie", 0, 49);
        GildedRose app = new GildedRose(toArray(item));

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(50);

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(-2);
        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void qualityOfBackstagePassesShouldIncreaseByOneWhenThereAreMoreThanTenDaysRemaining() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 0);
        GildedRose app = new GildedRose(toArray(item));

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(10);
        assertThat(item.quality).isEqualTo(5);
    }

    @Test
    void qualityOfBackstagePassesShouldIncreaseByTwoWhenThereAreBetweenTenAndFiveDaysRemaining() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0);
        GildedRose app = new GildedRose(toArray(item));

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(5);
        assertThat(item.quality).isEqualTo(10);
    }

    @Test
    void qualityOfBackstagePassesShouldIncreaseByTwoWhenThereAreBetweenFiveAndZeroDaysRemaining() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0);
        GildedRose app = new GildedRose(toArray(item));

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertThat(item.sellIn).isZero();
        assertThat(item.quality).isEqualTo(15);
    }

    @Test
    void qualityOfBackstagePassesShouldIncreaseBeZeroAfterConcert() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        GildedRose app = new GildedRose(toArray(item));

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isZero();

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(-2);
        assertThat(item.quality).isZero();
    }

    private static Item[] toArray(Item item) {
        return new Item[] { item };
    }

}
