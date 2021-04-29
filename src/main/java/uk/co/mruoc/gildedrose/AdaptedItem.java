package uk.co.mruoc.gildedrose;

public abstract class AdaptedItem implements UpdatableItem {

    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;

    private final Item item;

    protected AdaptedItem(Item item) {
        this.item = item;
    }

    @Override
    public int getSellIn() {
        return item.sellIn;
    }

    @Override
    public int getQuality() {
        return item.quality;
    }

    @Override
    public String getName() {
        return item.name;
    }

    protected void decrementSellIn() {
        item.sellIn -= 1;
    }

    protected void decreaseQualityIfAllowed(int amount) {
        item.quality = Math.max(MIN_QUALITY, item.quality - amount);
    }

    protected void increaseQualityIfAllowed(int amount) {
        item.quality = Math.min(MAX_QUALITY, item.quality + amount);
    }

}
