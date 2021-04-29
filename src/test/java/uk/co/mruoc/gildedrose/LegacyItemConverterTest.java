package uk.co.mruoc.gildedrose;

import org.junit.jupiter.api.Test;
import uk.co.mruoc.gildedrose.adapteditems.AgedBrie;
import uk.co.mruoc.gildedrose.adapteditems.BackstagePasses;
import uk.co.mruoc.gildedrose.adapteditems.Conjured;
import uk.co.mruoc.gildedrose.adapteditems.GenericItem;
import uk.co.mruoc.gildedrose.adapteditems.Sulfuras;
import uk.co.mruoc.gildedrose.adapteditems.UpdatableItem;

import static org.assertj.core.api.Assertions.assertThat;

class LegacyItemConverterTest {

    private final LegacyItemConverter converter = new LegacyItemConverter();

    @Test
    void shouldConvertLegacyItemWithNameAgedBrieToUpdatableItem() {
        Item legacyItem = new Item(AgedBrie.NAME, 0, 0);

        UpdatableItem item = converter.toUpdatableItem(legacyItem);

        assertThat(item).isInstanceOf(AgedBrie.class);
        assertThat(item).usingRecursiveComparison()
                .ignoringFields("item")
                .isEqualTo(legacyItem);
    }

    @Test
    void shouldConvertLegacyItemWithNameBackstagePassesToUpdatableItem() {
        Item legacyItem = new Item(BackstagePasses.NAME, 0, 0);

        UpdatableItem item = converter.toUpdatableItem(legacyItem);

        assertThat(item).isInstanceOf(BackstagePasses.class);
        assertThat(item).usingRecursiveComparison()
                .ignoringFields("item")
                .isEqualTo(legacyItem);
    }

    @Test
    void shouldConvertLegacyItemWithNameSulfurasToUpdatableItem() {
        Item legacyItem = new Item(Sulfuras.NAME, 0, 0);

        UpdatableItem item = converter.toUpdatableItem(legacyItem);

        assertThat(item).isInstanceOf(Sulfuras.class);
        assertThat(item).usingRecursiveComparison()
                .ignoringFields("item")
                .isEqualTo(legacyItem);
    }

    @Test
    void shouldConvertLegacyItemWithNameConjuredToUpdatableItem() {
        Item legacyItem = new Item(Conjured.NAME, 0, 0);

        UpdatableItem item = converter.toUpdatableItem(legacyItem);

        assertThat(item).isInstanceOf(Conjured.class);
        assertThat(item).usingRecursiveComparison()
                .ignoringFields("item")
                .isEqualTo(legacyItem);
    }

    @Test
    void shouldConvertLegacyItemWithAnyOtherNameToGenericUpdatableItem() {
        Item legacyItem = new Item("any-name", 0, 0);

        UpdatableItem item = converter.toUpdatableItem(legacyItem);

        assertThat(item).isInstanceOf(GenericItem.class);
        assertThat(item).usingRecursiveComparison()
                .ignoringFields("item")
                .isEqualTo(legacyItem);
    }

    @Test
    void shouldConvertMultipleLegacyItems() {
        Item legacyItem1 = new Item("item-1", 1, 1);
        Item legacyItem2 = new Item("item-2", 2, 2);

        UpdatableItem[] items = converter.toUpdatableItems(legacyItem1, legacyItem2);

        UpdatableItem item1 = items[0];
        assertThat(item1).isInstanceOf(GenericItem.class);
        assertThat(item1).usingRecursiveComparison()
                .ignoringFields("item")
                .isEqualTo(legacyItem1);
        UpdatableItem item2 = items[1];
        assertThat(item2).isInstanceOf(GenericItem.class);
        assertThat(item2).usingRecursiveComparison()
                .ignoringFields("item")
                .isEqualTo(legacyItem2);
    }

}
