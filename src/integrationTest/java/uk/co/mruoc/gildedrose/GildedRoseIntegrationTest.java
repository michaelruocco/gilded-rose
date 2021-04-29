package uk.co.mruoc.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseIntegrationTest {

    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    @Test
    void sellInOfGenericItemShouldDecreaseByOne() {
        Item item = new GenericItem(0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.sellIn).isEqualTo(-5);
    }

    @Test
    void qualityOfGenericItemShouldDecreaseByOneBeforeSellInDate() {
        Item item = new GenericItem(1, 10);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.quality).isEqualTo(9);
    }

    @Test
    void qualityOfGenericItemShouldDecreaseByTwoAfterSellInDate() {
        Item item = new GenericItem(0, 10);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.quality).isEqualTo(8);
    }

    @Test
    void qualityOfGenericItemShouldNotGoBelowZero() {
        Item item = new GenericItem(0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.quality).isZero();
    }

    @Test
    void sellInOfAgedBrieShouldDecreaseByOne() {
        Item item = new AgedBrie(0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.sellIn).isEqualTo(-5);
    }

    @Test
    void qualityOfAgedBrieShouldIncreaseByOne() {
        Item item = new AgedBrie(0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.quality).isEqualTo(1);
    }

    @Test
    void qualityOfAgedBrieShouldNotGoAboveFifty() {
        Item item = new AgedBrie(0, 50);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void sellInOfBackstagePassesShouldDecreaseByOne() {
        Item item = new BackstagePasses(0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.sellIn).isEqualTo(-5);
    }

    @Test
    void qualityOfBackstagePassesShouldIncreaseByOneWhenMoreThanTenDaysRemaining() {
        Item item = new BackstagePasses(15, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.quality).isEqualTo(5);
    }

    @Test
    void qualityOfBackstagePassesShouldIncreaseByTwoWhenBetweenFiveAndTenDaysRemaining() {
        Item item = new BackstagePasses(10, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.quality).isEqualTo(10);
    }

    @Test
    void qualityOfBackstagePassesShouldIncreaseByThreeWhenBetweenZeroAndFiveDaysRemaining() {
        Item item = new BackstagePasses(5, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.quality).isEqualTo(15);
    }

    @Test
    void qualityOfBackstagePassesShouldNotGoAboveFifty() {
        Item item = new BackstagePasses(1, 50);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void qualityOfBackstagePassesShouldBeZeroAfterConcert() {
        Item item = new BackstagePasses( 0, 10);
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
    void qualityOfSulfurasShouldNotChange() {
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
