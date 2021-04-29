package uk.co.mruoc.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GenericItemTest {

    @Test
    void shouldReturnGenericItemNameByDefault() {
        GenericItem item = new GenericItem(0, 0);

        String name = item.getName();

        assertThat(name).isEqualTo("Generic Item");
    }

    @Test
    void shouldReturnCustomNameIfSpecified() {
        String expectedName = "My Custom Name";
        GenericItem item = new GenericItem(expectedName,0, 0);

        String name = item.getName();

        assertThat(name).isEqualTo(expectedName);
    }

    @Test
    void shouldDecrementSellBy() {
        GenericItem item = new GenericItem(0, 0);

        item.update();

        assertThat(item.getSellBy()).isEqualTo(-1);
    }

    @Test
    void shouldDegradeQualityByOneBeforeSellByDate() {
        GenericItem item = new GenericItem(0, 1);

        item.update();

        assertThat(item.getQuality()).isZero();
    }

    @Test
    void shouldDegradeQualityByTwoAfterSellByDate() {
        GenericItem item = new GenericItem(-1, 2);

        item.update();

        assertThat(item.getQuality()).isZero();
    }

    @Test
    void shouldDegradeQualityShouldNotGoBelowZero() {
        GenericItem item = new GenericItem(0, 0);

        item.update();

        assertThat(item.getQuality()).isZero();
    }

}
