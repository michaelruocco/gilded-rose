package uk.co.mruoc.gildedrose;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
class GildedRose {

    private final UpdatableItem[] items;

    public void updateQuality() {
        Arrays.stream(items).forEach(UpdatableItem::update);
    }

}
