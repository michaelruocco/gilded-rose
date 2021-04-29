package uk.co.mruoc.gildedrose;

public class AgedBrie extends Item implements UpdatableItem {

    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void update() {
        decrementSellIn();
        increaseQualityIfAllowed();
    }

    @Override
    public int getSellIn() {
        return sellIn;
    }

    @Override
    public int getQuality() {
        return quality;
    }

    @Override
    public String getName() {
        return name;
    }

    private void decrementSellIn() {
        sellIn -= 1;
    }

    private void increaseQualityIfAllowed() {
        quality = Math.min(50, quality + 1);
    }

}
