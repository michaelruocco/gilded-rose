package uk.co.mruoc.gildedrose.adapteditem;

import org.junit.jupiter.api.Test;
import uk.co.mruoc.gildedrose.adapteditems.Conjured;
import uk.co.mruoc.gildedrose.adapteditems.UpdatableItem;

import static org.assertj.core.api.Assertions.assertThat;

class ConjuredTest {

    @Test
    void shouldReturnGenericConjuredNameByDefault() {
        UpdatableItem item = new Conjured(0, 0);

        String name = item.getName();

        assertThat(name).isEqualTo("Conjured Mana Cake");
    }

    @Test
    void shouldDecreaseSellInByOne() {
        UpdatableItem item = new Conjured(1, 0);

        item.update();

        assertThat(item.getSellIn()).isZero();
    }

    @Test
    void shouldDecreaseQualityByTwoBeforeSellInDate() {
        UpdatableItem item = new Conjured(0, 2);

        item.update();

        assertThat(item.getQuality()).isZero();
    }

    @Test
    void shouldDecreaseQualityByFourAfterSellInDate() {
        UpdatableItem item = new Conjured(-1, 4);

        item.update();

        assertThat(item.getQuality()).isZero();
    }

    @Test
    void qualityShouldNotGoBelowZero() {
        UpdatableItem item = new Conjured(0, 0);

        item.update();

        assertThat(item.getQuality()).isZero();
    }

}
