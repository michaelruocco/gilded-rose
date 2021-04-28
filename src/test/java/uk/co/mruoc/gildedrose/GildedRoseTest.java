package uk.co.mruoc.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void sellInOfNormalItemShouldDecreaseByOne() {
        Item item = toNormalItemWithQuality(0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.sellIn).isEqualTo(-5);
    }

    @Test
    void qualityOfNormalItemShouldNeverBeNegative() {
        Item item = toNormalItemWithQuality(0);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.quality).isZero();
    }

    @Test
    void qualityOfNormalItemShouldDegradeByTwoAfterSellByDate() {
        Item item = toNormalItemWithQuality(10);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.quality).isEqualTo(8);
    }

    @Test
    void sellInOfAgedBrieShouldDecreaseByOne() {
        Item item = new Item("Aged Brie", 0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.sellIn).isEqualTo(-5);
    }

    @Test
    void qualityOfAgedBrieShouldIncreaseByTwoTheOlderItGets() {
        Item item = new Item("Aged Brie", 0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.quality).isEqualTo(2);
    }

    @Test
    void qualityOfAgedBrieShouldNeverIncreaseAboveFifty() {
        Item item = new Item("Aged Brie", 0, 50);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void sellInOfBackstagePassesShouldDecreaseByOne() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.sellIn).isEqualTo(-5);
    }

    @Test
    void qualityOfBackstagePassesShouldIncreaseByOneWhenThereAreMoreThanTenDaysRemaining() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.quality).isEqualTo(5);
    }

    @Test
    void qualityOfBackstagePassesShouldIncreaseByTwoWhenThereAreBetweenTenAndFiveDaysRemaining() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.quality).isEqualTo(10);
    }

    @Test
    void qualityOfBackstagePassesShouldIncreaseByTwoWhenThereAreBetweenFiveAndZeroDaysRemaining() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.quality).isEqualTo(15);
    }

    @Test
    void qualityOfBackstagePassesShouldNotIncreaseAboveFifty() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void qualityOfBackstagePassesShouldBeZeroAfterConcert() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.quality).isZero();
    }

    @Test
    void sellInOfSulfurasShouldNotChange() {
        Item item = buildSulfuras();
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.sellIn).isZero();
    }

    @Test
    void sellInOfQualityOfSulfurasShouldNotChange() {
        Item item = buildSulfuras();
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.quality).isZero();
    }

    private void executeNTimes(int n, Runnable action) {
        IntStream.range(0, n).forEach(i -> action.run());
    }

    private static GildedRose toGildedRose(Item item) {
        return new GildedRose(toArray(item));
    }

    private static Item[] toArray(Item item) {
        return new Item[]{item};
    }

    private static Item toNormalItemWithQuality(int quantity) {
        return new Item("normal-item", 0, quantity);
    }

    private static Item buildSulfuras() {
        return new Item("Sulfuras, Hand of Ragnaros", 0, 0);
    }

}
