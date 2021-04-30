package uk.co.mruoc.gildedrose.adapteditems;

import uk.co.mruoc.gildedrose.Item;

public class BackstagePasses extends AdaptedItem implements UpdatableItem {

    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePasses(int sellIn, int quality) {
        this(new Item(NAME, sellIn, quality));
    }

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decrementSellIn();
        if (hasPassedSellBy()) {
            decreaseToZero();
            return;
        }
        increaseQualityIfAllowed(calculateQualityIncrease());
    }

    private void decreaseToZero() {
        decreaseQualityIfAllowed(getQuality());
    }

    private int calculateQualityIncrease() {
        int sellIn = getSellIn();
        if (sellIn >= 10) {
            return 1;
        }
        if (sellIn >= 5) {
            return 2;
        }
        return 3;
    }

}
