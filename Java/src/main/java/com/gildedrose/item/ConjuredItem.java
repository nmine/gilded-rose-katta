package com.gildedrose.item;

import com.gildedrose.Item;

public class ConjuredItem extends StandardItem {

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    void updateSellIn() {
        super.updateSellIn();
    }

    @Override
    void updateQuality() {
        qualityDecreaseTwiceAsStandardItem();
    }

    private void qualityDecreaseTwiceAsStandardItem() {
        super.updateQuality();
        super.updateQuality();
    }
}
