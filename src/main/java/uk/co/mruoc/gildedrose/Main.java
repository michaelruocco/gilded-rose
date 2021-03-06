package uk.co.mruoc.gildedrose;

import java.util.stream.IntStream;

public class Main {

    private Main() {
        // main class
    }

    public static void main(String[] args) {
        Item[] items = new ItemsSupplier().get();
        var app = new GildedRose(items);
        IntStream.range(0, new ArgumentParser().toDays(args))
                .mapToObj(day -> new ItemReportGenerator().generate(day, items))
                .forEach(report -> printAndUpdate(report, app));
    }

    private static void printAndUpdate(String report, GildedRose app) {
        System.out.println(report);
        app.updateQuality();
    }

}
