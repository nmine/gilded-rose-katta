package com.gildedrose.item;

import com.gildedrose.Item;

public class AgedBrieItem extends UpdatableItem {

    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    void updateSellIn() {
        decreaseSeelIn();
    }

    @Override
    void updateQuality() {
        increaseQualityIfBelowMax();
    }

}
