package uk.co.mruoc.gildedrose;

import lombok.RequiredArgsConstructor;
import uk.co.mruoc.gildedrose.adapteditems.LegacyItemConverter;
import uk.co.mruoc.gildedrose.adapteditems.UpdatableItem;

import java.util.Arrays;

@RequiredArgsConstructor
class GildedRose {

    private final UpdatableItem[] items;

    public GildedRose(Item[] items) {
        this(new LegacyItemConverter().toUpdatableItems(items));
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(UpdatableItem::update);
    }

}
