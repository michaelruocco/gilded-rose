package uk.co.mruoc.gildedrose;

import uk.co.mruoc.gildedrose.adapteditems.AgedBrie;
import uk.co.mruoc.gildedrose.adapteditems.BackstagePasses;
import uk.co.mruoc.gildedrose.adapteditems.GenericItem;
import uk.co.mruoc.gildedrose.adapteditems.Sulfuras;
import uk.co.mruoc.gildedrose.adapteditems.UpdatableItem;

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
            default -> new GenericItem(legacyItem);
        };
    }

}
