package uk.co.mruoc.gildedrose;

public class BackstagePasses extends AbstractItem implements UpdatableItem {

    public BackstagePasses(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void update() {
        decrementSellIn();
        if (isAfterConcert()) {
            quality = 0;
        } else {
            increaseQualityIfAllowed(calculateQualityIncrease());
        }
    }

    private void decrementSellIn() {
        sellIn -= 1;
    }

    private boolean isAfterConcert() {
        return sellIn < 0;
    }

    private void increaseQualityIfAllowed(int amount) {
        quality = Math.min(50, quality + amount);
    }

    private int calculateQualityIncrease() {
        if (sellIn >= 10) {
            return 1;
        }
        if (sellIn >= 5) {
            return 2;
        }
        return 3;
    }

}
