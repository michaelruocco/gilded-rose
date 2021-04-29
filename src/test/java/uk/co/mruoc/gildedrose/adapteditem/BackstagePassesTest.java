package uk.co.mruoc.gildedrose.adapteditem;

import org.junit.jupiter.api.Test;
import uk.co.mruoc.gildedrose.adapteditems.BackstagePasses;
import uk.co.mruoc.gildedrose.adapteditems.UpdatableItem;

import static org.assertj.core.api.Assertions.assertThat;

class BackstagePassesTest {

    @Test
    void shouldReturnBackstagePassNameByDefault() {
        UpdatableItem item = new BackstagePasses(0, 0);

        String name = item.getName();

        assertThat(name).isEqualTo("Backstage passes to a TAFKAL80ETC concert");
    }

    @Test
    void shouldDecreaseSellInByOne() {
        UpdatableItem item = new BackstagePasses(0, 0);

        item.update();

        assertThat(item.getSellIn()).isEqualTo(-1);
    }

    @Test
    void shouldIncreaseQualityByOneWhenMoreThanTenDaysRemaining() {
        UpdatableItem item = new BackstagePasses(15, 0);

        item.update();

        assertThat(item.getQuality()).isEqualTo(1);
    }

    @Test
    void shouldIncreaseQualityByTwoWhenBetweenFiveAndTenDaysRemaining() {
        UpdatableItem item = new BackstagePasses(10, 0);

        item.update();

        assertThat(item.getQuality()).isEqualTo(2);
    }

    @Test
    void shouldIncreaseQualityByThreeWhenBetweenZeroAndFiveDaysRemaining() {
        UpdatableItem item = new BackstagePasses(10, 0);

        item.update();

        assertThat(item.getQuality()).isEqualTo(2);
    }

    @Test
    void qualityShouldNotGoAboveFifty() {
        UpdatableItem item = new BackstagePasses(1, 50);

        item.update();

        assertThat(item.getQuality()).isEqualTo(50);
    }

    @Test
    void qualityShouldBeZeroAfterConcert() {
        UpdatableItem item = new BackstagePasses(0, 50);

        item.update();

        assertThat(item.getQuality()).isZero();
    }

}
