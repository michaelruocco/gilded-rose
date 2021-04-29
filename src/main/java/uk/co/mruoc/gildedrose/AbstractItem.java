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

}
