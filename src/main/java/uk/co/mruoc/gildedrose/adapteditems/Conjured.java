package uk.co.mruoc.gildedrose.adapteditems;

import uk.co.mruoc.gildedrose.Item;

public class Conjured extends AdaptedItem implements UpdatableItem {

    public static final String NAME = "Conjured Mana Cake";

    public Conjured(int sellIn, int quality) {
        this(new Item(NAME, sellIn, quality));
    }

    public Conjured(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decrementSellIn();
        decreaseQualityIfAllowed(calculateQualityDecrease());
    }

    private int calculateQualityDecrease() {
        if (hasPassedSellBy()) {
            return 4;
        }
        return 2;
    }

}
