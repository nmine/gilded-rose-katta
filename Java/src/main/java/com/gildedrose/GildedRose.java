package com.gildedrose;

import com.gildedrose.item.*;

import static com.gildedrose.item.ItemFactory.*;
import static java.util.Arrays.stream;

class GildedRose {

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        stream(this.items).forEach(item -> ItemFactory.from(item).update());
    }

    Item getItem(int index) {
        return items[index];
    }
}