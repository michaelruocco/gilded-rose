package uk.co.mruoc.gildedrose;

import java.util.Arrays;

public class ItemConverter {

    public UpdatableItem[] toUpdatableItems(Item[] items) {
        return Arrays.stream(items)
                .map(this::toUpdatableItem)
                .toArray(UpdatableItem[]::new);
    }

    public UpdatableItem toUpdatableItem(Item item) {
        return switch (item.name) {
            case AgedBrie.NAME -> new AgedBrie(item);
            case BackstagePasses.NAME -> new BackstagePasses(item);
            case Sulfuras.NAME -> new Sulfuras(item);
            default -> new GenericItem(item);
        };
    }

}
