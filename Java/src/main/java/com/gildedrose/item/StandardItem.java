package com.gildedrose.item;

import com.gildedrose.Item;

public class StandardItem extends UpdatableItem {

    public StandardItem(Item item) {
        super(item);
    }

    @Override
    void updateSellIn() {
        decreaseSeelIn();
    }

    @Override
    void updateQuality() {
        decreaseQuality();
        decreaseQualityIfOutdatedItem();
    }

    private void decreaseQualityIfOutdatedItem() {
        if (this.item.sellIn < 0) {
            decreaseQuality();
        }
    }
}
