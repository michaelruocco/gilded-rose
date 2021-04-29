package uk.co.mruoc.gildedrose;

public abstract class AbstractItem extends Item implements UpdatableItem {

    protected AbstractItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
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

    protected void decrementSellIn() {
        sellIn -= 1;
    }

    protected void decreaseQualityIfAllowed(int amount) {
        quality = Math.max(0, quality - amount);
    }

    protected void increaseQualityIfAllowed(int amount) {
        quality = Math.min(50, quality + amount);
    }

}
