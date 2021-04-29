package uk.co.mruoc.gildedrose;

public class DefaultItem extends Item {

    public DefaultItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        decreaseQualityIfAllowed(calculateQualityDecrease());
        decrementSellIn();
    }

    public int getSellBy() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    private void decrementSellIn() {
        sellIn -= 1;
    }

    private void decreaseQualityIfAllowed(int amount) {
        quality = Math.max(0, quality - amount);
    }

    private int calculateQualityDecrease() {
        if (sellIn < 0) {
            return 2;
        }
        return 1;
    }

}
