package uk.co.mruoc.gildedrose;

public class AgedBrie extends AbstractItem implements UpdatableItem {

    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void update() {
        decrementSellIn();
        increaseQualityIfAllowed();
    }

    private void decrementSellIn() {
        sellIn -= 1;
    }

    private void increaseQualityIfAllowed() {
        quality = Math.min(50, quality + 1);
    }

}
