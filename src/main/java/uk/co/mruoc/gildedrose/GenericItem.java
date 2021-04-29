package uk.co.mruoc.gildedrose;

public class GenericItem extends AbstractItem implements UpdatableItem {

    private static final String DEFAULT_NAME = "Generic Item";

    public GenericItem(int sellIn, int quality) {
        this(DEFAULT_NAME, sellIn, quality);
    }

    public GenericItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        decrementSellIn();
        decreaseQualityIfAllowed(calculateQualityDecrease());
    }

    private int calculateQualityDecrease() {
        if (sellIn < 0) {
            return 2;
        }
        return 1;
    }

}