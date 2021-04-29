package uk.co.mruoc.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SulfurasTest {

    private static final int QUALITY = 80;

    @Test
    void shouldReturnAgedBrieNameByDefault() {
        UpdatableItem item = new Sulfuras();

        String name = item.getName();

        assertThat(name).isEqualTo("Sulfuras, Hand of Ragnaros");
    }

    @Test
    void sellInShouldBeZeroByDefault() {
        UpdatableItem item = new Sulfuras();

        int sellIn = item.getSellIn();

        assertThat(sellIn).isZero();
    }

    @Test
    void shouldSetSellInIfSpecified() {
        int expectedSellIn = 5;
        UpdatableItem item = new Sulfuras(expectedSellIn);

        int sellIn = item.getSellIn();

        assertThat(sellIn).isEqualTo(expectedSellIn);
    }

    @Test
    void shouldNotChangeSellIn() {
        UpdatableItem item = new Sulfuras();

        item.update();

        assertThat(item.getSellIn()).isZero();
    }

    @Test
    void qualityShouldBeEightyByDefault() {
        UpdatableItem item = new Sulfuras();

        int quality = item.getQuality();

        assertThat(quality).isEqualTo(QUALITY);
    }

    @Test
    void shouldNotChangeQuality() {
        UpdatableItem item = new Sulfuras();

        item.update();

        assertThat(item.getQuality()).isEqualTo(QUALITY);
    }

}
