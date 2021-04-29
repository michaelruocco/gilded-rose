package uk.co.mruoc.gildedrose;

import uk.co.mruoc.gildedrose.adapteditems.AgedBrie;
import uk.co.mruoc.gildedrose.adapteditems.BackstagePasses;
import uk.co.mruoc.gildedrose.adapteditems.Conjured;
import uk.co.mruoc.gildedrose.adapteditems.Sulfuras;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println("OMGHAI!");
        Item[] items = buildItems();
        GildedRose app = new GildedRose(items);
        int days = toDays(args);
        IntStream.range(0, days).forEach(day -> printDayAndUpdate(day, items, app));
    }

    private static Item[] buildItems() {
        return new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item(AgedBrie.NAME, 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item(Sulfuras.NAME, 0, 80),
                new Item(Sulfuras.NAME, -1, 80),
                new Item(BackstagePasses.NAME, 15, 20),
                new Item(BackstagePasses.NAME, 10, 49),
                new Item(BackstagePasses.NAME, 5, 49),
                new Item(Conjured.NAME, 3, 6)};
    }

    private static int toDays(String[] args) {
        if (args.length > 0) {
            return Integer.parseInt(args[0]) + 1;
        }
        return 2;
    }

    private static void printDayAndUpdate(int day, Item[] items, GildedRose app) {
        print(day, items);
        app.updateQuality();
    }

    private static void print(int day, Item[] items) {
        System.out.println("-------- day " + day + " --------");
        System.out.println("name, sellIn, quality");
        Arrays.stream(items).forEach(System.out::println);
        System.out.println();
    }

}
