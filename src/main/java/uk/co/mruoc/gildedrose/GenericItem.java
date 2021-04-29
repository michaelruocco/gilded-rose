package uk.co.mruoc.gildedrose;

public class GenericItem extends AdaptedItem implements UpdatableItem {

    private static final String DEFAULT_NAME = "Generic Item";

    public GenericItem(int sellIn, int quality) {
        this(DEFAULT_NAME, sellIn, quality);
    }

    public GenericItem(String name, int sellIn, int quality) {
        this(new Item(name, sellIn, quality));
    }

    public GenericItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        decrementSellIn();
        decreaseQualityIfAllowed(calculateQualityDecrease());
    }

    private int calculateQualityDecrease() {
        if (getSellIn() < 0) {
            return 2;
        }
        return 1;
    }

}
