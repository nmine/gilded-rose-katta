package com.gildedrose;

import com.gildedrose.item.AgedBrieItem;
import com.gildedrose.item.BackstageItem;
import com.gildedrose.item.StandardItem;
import com.gildedrose.item.SulfurasItem;

import static com.gildedrose.Items.*;
import static java.util.Arrays.stream;

class GildedRose {

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        stream(this.items).forEach(item -> {
            switch (item.name) {
                case STANDARD:
                    new StandardItem(item).update();
                    break;
                case SULFURAS:
                    new SulfurasItem(item).update();
                    break;
                case AGED_BRIE:
                    new AgedBrieItem(item).update();
                    break;
                case BACKSTAGE:
                    new BackstageItem(item).update();
                    break;
            }
        });
    }

    Item getItem(int index) {
        return items[index];
    }
}