package com.gildedrose;

import com.gildedrose.documentation.DesignPattern;
import com.gildedrose.documentation.Type;
import com.gildedrose.item.ItemFactory;

import static com.gildedrose.documentation.Type.*;

@DesignPattern(BUILDER)
public class ItemBuilder {

    public static final String DEFAULT_NAME = ItemFactory.STANDARD;
    public static final int DEFAULT_SELLIN = 10;
    public static final int DEFAULT_QUALITY = 10;

    private String name = DEFAULT_NAME;
    private int sellIn = DEFAULT_SELLIN;
    private int quality = DEFAULT_QUALITY;

    public Item build() {
        return new Item(this.name, this.sellIn, this.quality);
    }

    public ItemBuilder withName(final String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder withSellIn(final int sellIn) {
        this.sellIn = sellIn;
        return this;
    }

    public ItemBuilder withQuality(final int quality) {
        this.quality = quality;
        return this;
    }

}
