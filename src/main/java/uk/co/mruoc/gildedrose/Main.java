package uk.co.mruoc.gildedrose;

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
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};
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
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println();
    }

}
