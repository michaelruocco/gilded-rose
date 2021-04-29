package uk.co.mruoc.gildedrose.adapteditem;

import org.junit.jupiter.api.Test;
import uk.co.mruoc.gildedrose.adapteditems.AgedBrie;
import uk.co.mruoc.gildedrose.adapteditems.UpdatableItem;

import static org.assertj.core.api.Assertions.assertThat;

class AgedBrieTest {

    @Test
    void shouldReturnAgedBrieNameByDefault() {
        UpdatableItem item = new AgedBrie(0, 0);

        String name = item.getName();

        assertThat(name).isEqualTo("Aged Brie");
    }

    @Test
    void shouldDecreaseSellInByOne() {
        UpdatableItem item = new AgedBrie(0, 0);

        item.update();

        assertThat(item.getSellIn()).isEqualTo(-1);
    }

    @Test
    void shouldIncreaseQualityByOne() {
        UpdatableItem item = new AgedBrie(0, 0);

        item.update();

        assertThat(item.getQuality()).isEqualTo(1);
    }

    @Test
    void qualityShouldNotGoAboveFifty() {
        UpdatableItem item = new AgedBrie(0, 50);

        item.update();

        assertThat(item.getQuality()).isEqualTo(50);
    }

}
