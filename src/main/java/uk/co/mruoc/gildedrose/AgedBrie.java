package uk.co.mruoc.gildedrose;

public class AgedBrie extends AbstractItem implements UpdatableItem {

    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void update() {
        decrementSellIn();
        increaseQualityIfAllowed(1);
    }

}
