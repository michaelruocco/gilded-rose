package uk.co.mruoc.gildedrose;

public class AgedBrie extends AdaptedItem implements UpdatableItem {

    public static final String NAME = "Aged Brie";

    public AgedBrie(int sellIn, int quality) {
        this(new Item(NAME, sellIn, quality));
    }

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decrementSellIn();
        increaseQualityIfAllowed(1);
    }

}
