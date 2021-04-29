package uk.co.mruoc.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultItemTest {

    private static final String NAME = "item-name";

    @Test
    void shouldDecrementSellBy() {
        DefaultItem item = new DefaultItem(NAME, 0, 0);

        item.update();

        assertThat(item.getSellBy()).isEqualTo(-1);
    }

    @Test
    void shouldDegradeQualityByOneBeforeSellByDate() {
        DefaultItem item = new DefaultItem(NAME, 0, 1);

        item.update();

        assertThat(item.getQuality()).isZero();
    }

    @Test
    void shouldDegradeQualityByTwoAfterSellByDate() {
        DefaultItem item = new DefaultItem(NAME, -1, 2);

        item.update();

        assertThat(item.getQuality()).isZero();
    }

    @Test
    void shouldDegradeQualityShouldNotGoBelowZero() {
        DefaultItem item = new DefaultItem(NAME, 0, 0);

        item.update();

        assertThat(item.getQuality()).isZero();
    }

}
