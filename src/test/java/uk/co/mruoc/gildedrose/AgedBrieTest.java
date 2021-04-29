package uk.co.mruoc.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AgedBrieTest {

    @Test
    void shouldReturnAgedBrieNameByDefault() {
        UpdatableItem item = new AgedBrie(0, 0);

        String name = item.getName();

        assertThat(name).isEqualTo("Aged Brie");
    }

    @Test
    void shouldDecreaseSellByByOne() {
        UpdatableItem item = new AgedBrie(0, 0);

        item.update();

        assertThat(item.getSellBy()).isEqualTo(-1);
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
