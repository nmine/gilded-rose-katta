package com.gildedrose.item;

import com.gildedrose.Item;

public class BackstageItem extends UpdatableItem {

    public BackstageItem(Item item) {
        super(item);
    }

    @Override
    void updateSellIn() {
        decreaseSeelIn();
    }

    @Override
    void updateQuality() {
        if (isQualityBelowMax()) {
            increaseQuality();
            if (isSellInBelow(11))
                increaseQuality();

            if (isSellInBelow(6))
                increaseQuality();
        }
        setQuality0ForOutdatedItem();
    }

    private void setQuality0ForOutdatedItem() {
        if (isSellInBelow(0))
            setQualityTo0();
    }

}
