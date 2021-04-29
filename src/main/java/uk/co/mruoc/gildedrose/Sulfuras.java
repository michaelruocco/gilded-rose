package uk.co.mruoc.gildedrose;

public class Sulfuras extends AdaptedItem implements UpdatableItem {

    public static final String NAME = "Sulfuras, Hand of Ragnaros";

    private static final int DEFAULT_SELL_IN = 0;
    private static final int QUALITY = 80;

    public Sulfuras() {
        this(DEFAULT_SELL_IN);
    }

    public Sulfuras(int sellIn) {
        this(new Item(NAME, sellIn, QUALITY));
    }

    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    public void update() {
        //intentionally blank
    }

}
