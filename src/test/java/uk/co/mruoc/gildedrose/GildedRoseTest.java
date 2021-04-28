package uk.co.mruoc.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    private static final String GENERIC_ITEM = "generic-item";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    @Test
    void sellInOfGenericItemShouldDecreaseByOne() {
        Item item = new Item(GENERIC_ITEM, 0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.sellIn).isEqualTo(-5);
    }

    @Test
    void qualityOfGenericItemShouldNeverBeNegative() {
        Item item = new Item(GENERIC_ITEM, 0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.quality).isZero();
    }

    @Test
    void qualityOfGenericItemShouldDegradeByTwoAfterSellByDate() {
        Item item = new Item(GENERIC_ITEM, 0, 10);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.quality).isEqualTo(8);
    }

    @Test
    void sellInOfAgedBrieShouldDecreaseByOne() {
        Item item = new Item(AGED_BRIE, 0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.sellIn).isEqualTo(-5);
    }

    @Test
    void qualityOfAgedBrieShouldIncreaseByTwoTheOlderItGets() {
        Item item = new Item(AGED_BRIE, 0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.quality).isEqualTo(2);
    }

    @Test
    void qualityOfAgedBrieShouldNeverIncreaseAboveFifty() {
        Item item = new Item(AGED_BRIE, 0, 50);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void sellInOfBackstagePassesShouldDecreaseByOne() {
        Item item = new Item(BACKSTAGE_PASSES, 0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.sellIn).isEqualTo(-5);
    }

    @Test
    void qualityOfBackstagePassesShouldIncreaseByOneWhenThereAreMoreThanTenDaysRemaining() {
        Item item = new Item(BACKSTAGE_PASSES, 15, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.quality).isEqualTo(5);
    }

    @Test
    void qualityOfBackstagePassesShouldIncreaseByTwoWhenThereAreBetweenTenAndFiveDaysRemaining() {
        Item item = new Item(BACKSTAGE_PASSES, 10, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.quality).isEqualTo(10);
    }

    @Test
    void qualityOfBackstagePassesShouldIncreaseByTwoWhenThereAreBetweenFiveAndZeroDaysRemaining() {
        Item item = new Item(BACKSTAGE_PASSES, 5, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.quality).isEqualTo(15);
    }

    @Test
    void qualityOfBackstagePassesShouldNotIncreaseAboveFifty() {
        Item item = new Item(BACKSTAGE_PASSES, 1, 50);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void qualityOfBackstagePassesShouldBeZeroAfterConcert() {
        Item item = new Item(BACKSTAGE_PASSES, 0, 10);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.quality).isZero();
    }

    @Test
    void sellInOfSulfurasShouldNotChange() {
        Item item = new Item(SULFURAS, 0, 80);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.sellIn).isZero();
    }

    @Test
    void sellInOfQualityOfSulfurasShouldNotChange() {
        Item item = new Item(SULFURAS, 0, 80);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.quality).isEqualTo(80);
    }

    private void executeNTimes(int n, Runnable action) {
        IntStream.range(0, n).forEach(i -> action.run());
    }

    private static GildedRose toGildedRose(Item item) {
        return new GildedRose(toArray(item));
    }

    private static Item[] toArray(Item item) {
        return new Item[] { item };
    }

}
