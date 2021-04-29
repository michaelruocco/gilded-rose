package uk.co.mruoc.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseIntegrationTest {

    @Test
    void sellInOfGenericItemShouldDecreaseByOne() {
        UpdatableItem item = new GenericItem(0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.getSellIn()).isEqualTo(-5);
    }

    @Test
    void qualityOfGenericItemShouldDecreaseByOneBeforeSellInDate() {
        UpdatableItem item = new GenericItem(1, 10);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.getQuality()).isEqualTo(9);
    }

    @Test
    void qualityOfGenericItemShouldDecreaseByTwoAfterSellInDate() {
        UpdatableItem item = new GenericItem(0, 10);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.getQuality()).isEqualTo(8);
    }

    @Test
    void qualityOfGenericItemShouldNotGoBelowZero() {
        UpdatableItem item = new GenericItem(0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.getQuality()).isZero();
    }

    @Test
    void sellInOfAgedBrieShouldDecreaseByOne() {
        UpdatableItem item = new AgedBrie(0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.getSellIn()).isEqualTo(-5);
    }

    @Test
    void qualityOfAgedBrieShouldIncreaseByOne() {
        UpdatableItem item = new AgedBrie(0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.getQuality()).isEqualTo(1);
    }

    @Test
    void qualityOfAgedBrieShouldNotGoAboveFifty() {
        UpdatableItem item = new AgedBrie(0, 50);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.getQuality()).isEqualTo(50);
    }

    @Test
    void sellInOfBackstagePassesShouldDecreaseByOne() {
        UpdatableItem item = new BackstagePasses(0, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.getSellIn()).isEqualTo(-5);
    }

    @Test
    void qualityOfBackstagePassesShouldIncreaseByOneWhenMoreThanTenDaysRemaining() {
        UpdatableItem item = new BackstagePasses(15, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.getQuality()).isEqualTo(5);
    }

    @Test
    void qualityOfBackstagePassesShouldIncreaseByTwoWhenBetweenFiveAndTenDaysRemaining() {
        UpdatableItem item = new BackstagePasses(10, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.getQuality()).isEqualTo(10);
    }

    @Test
    void qualityOfBackstagePassesShouldIncreaseByThreeWhenBetweenZeroAndFiveDaysRemaining() {
        UpdatableItem item = new BackstagePasses(5, 0);
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.getQuality()).isEqualTo(15);
    }

    @Test
    void qualityOfBackstagePassesShouldNotGoAboveFifty() {
        UpdatableItem item = new BackstagePasses(1, 50);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.getQuality()).isEqualTo(50);
    }

    @Test
    void qualityOfBackstagePassesShouldBeZeroAfterConcert() {
        UpdatableItem item = new BackstagePasses( 0, 10);
        GildedRose app = toGildedRose(item);

        executeNTimes(1, app::updateQuality);

        assertThat(item.getQuality()).isZero();
    }

    @Test
    void sellInOfSulfurasShouldNotChange() {
        UpdatableItem item = new Sulfuras();
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.getSellIn()).isZero();
    }

    @Test
    void qualityOfSulfurasShouldNotChange() {
        UpdatableItem item = new Sulfuras();
        GildedRose app = toGildedRose(item);

        executeNTimes(5, app::updateQuality);

        assertThat(item.getQuality()).isEqualTo(80);
    }

    private void executeNTimes(int n, Runnable action) {
        IntStream.range(0, n).forEach(i -> action.run());
    }

    private static GildedRose toGildedRose(UpdatableItem item) {
        return new GildedRose(toArray(item));
    }

    private static UpdatableItem[] toArray(UpdatableItem item) {
        return new UpdatableItem[] { item };
    }

}
