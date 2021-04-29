package uk.co.mruoc.gildedrose;

public class Sulfuras extends AbstractItem implements UpdatableItem {

    private static final int DEFAULT_SELL_IN = 0;
    private static final int QUALITY = 80;

    public Sulfuras() {
        this(DEFAULT_SELL_IN);
    }

    public Sulfuras(int sellIn) {
        super("Sulfuras, Hand of Ragnaros", sellIn, QUALITY);
    }

    @Override
    public void update() {
        //intentionally blank
    }

}
