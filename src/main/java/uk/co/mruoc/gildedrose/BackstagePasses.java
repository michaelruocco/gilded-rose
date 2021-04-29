package uk.co.mruoc.gildedrose;

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
        increaseQualityIfAllowed(calculateQualityIncrease());
    }

    private int calculateQualityIncrease() {
        int sellIn = getSellIn();
        if (sellIn >= 10) {
            return 1;
        }
        if (sellIn >= 5) {
            return 2;
        }
        if (sellIn >= 0) {
            return 3;
        }
        return decreaseToZero();
    }

    private int decreaseToZero() {
        return -getQuality();
    }

}
