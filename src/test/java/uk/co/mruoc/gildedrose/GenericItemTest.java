package uk.co.mruoc.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GenericItemTest {

    @Test
    void shouldReturnGenericItemNameByDefault() {
        UpdatableItem item = new GenericItem(0, 0);

        String name = item.getName();

        assertThat(name).isEqualTo("Generic Item");
    }

    @Test
    void shouldReturnCustomNameIfSpecified() {
        String expectedName = "My Custom Name";
        UpdatableItem item = new GenericItem(expectedName,0, 0);

        String name = item.getName();

        assertThat(name).isEqualTo(expectedName);
    }

    @Test
    void shouldDecreaseSellInByOne() {
        UpdatableItem item = new GenericItem(0, 0);

        item.update();

        assertThat(item.getSellIn()).isEqualTo(-1);
    }

    @Test
    void shouldDecreaseQualityByOneBeforeSellInDate() {
        UpdatableItem item = new GenericItem(0, 1);

        item.update();

        assertThat(item.getQuality()).isZero();
    }

    @Test
    void shouldDecreaseQualityByTwoAfterSellInDate() {
        UpdatableItem item = new GenericItem(-1, 2);

        item.update();

        assertThat(item.getQuality()).isZero();
    }

    @Test
    void qualityShouldNotGoBelowZero() {
        UpdatableItem item = new GenericItem(0, 0);

        item.update();

        assertThat(item.getQuality()).isZero();
    }

}
