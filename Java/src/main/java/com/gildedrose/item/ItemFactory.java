package com.gildedrose.item;

import com.gildedrose.Item;

public class ItemFactory {
    public static final int MAX_QUALITY_VALUE = 50;
    public static final int MIN_QUALITY_VALUE = 0;


    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String STANDARD = "STANDARD Item";
    public static final String CONJURED = "Conjured";

    public static UpdatableItem from(Item item) {
        switch (item.name) {
            case STANDARD:
                return new StandardItem(item);
            case SULFURAS:
                return new SulfurasItem(item);
            case AGED_BRIE:
                return new AgedBrieItem(item);
            case BACKSTAGE:
                return new BackstageItem(item);
            case CONJURED:
                return new ConjuredItem(item);
            default:
                throw new RuntimeException("Invalid Item name");
        }
    }
}
