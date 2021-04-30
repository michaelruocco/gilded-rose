package uk.co.mruoc.gildedrose;

import uk.co.mruoc.gildedrose.adapteditems.AgedBrie;
import uk.co.mruoc.gildedrose.adapteditems.BackstagePasses;
import uk.co.mruoc.gildedrose.adapteditems.Conjured;
import uk.co.mruoc.gildedrose.adapteditems.Sulfuras;

import java.util.function.Supplier;

public class ItemsSupplier implements Supplier<Item[]> {

    @Override
    public Item[] get() {
        return new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item(AgedBrie.NAME, 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item(Sulfuras.NAME, 0, 80),
                new Item(Sulfuras.NAME, -1, 80),
                new Item(BackstagePasses.NAME, 15, 20),
                new Item(BackstagePasses.NAME, 10, 49),
                new Item(BackstagePasses.NAME, 5, 49),
                new Item(Conjured.NAME, 3, 6)
        };
    }

}
