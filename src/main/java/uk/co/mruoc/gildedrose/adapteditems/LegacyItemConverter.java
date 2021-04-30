package uk.co.mruoc.gildedrose.adapteditems;

import uk.co.mruoc.gildedrose.Item;

import java.util.Arrays;

public class LegacyItemConverter {

    public UpdatableItem[] toUpdatableItems(Item... legacyItems) {
        return Arrays.stream(legacyItems)
                .map(this::toUpdatableItem)
                .toArray(UpdatableItem[]::new);
    }

    public UpdatableItem toUpdatableItem(Item legacyItem) {
        return switch (legacyItem.name) {
            case AgedBrie.NAME -> new AgedBrie(legacyItem);
            case BackstagePasses.NAME -> new BackstagePasses(legacyItem);
            case Sulfuras.NAME -> new Sulfuras(legacyItem);
            case Conjured.NAME -> new Conjured(legacyItem);
            default -> new GenericItem(legacyItem);
        };
    }

}
