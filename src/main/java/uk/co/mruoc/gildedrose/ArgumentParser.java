package uk.co.mruoc.gildedrose;

public class ArgumentParser {

    public int toDays(String[] args) {
        if (args.length > 0) {
            return Integer.parseInt(args[0]) + 1;
        }
        return 2;
    }

}
