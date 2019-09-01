package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.documentation.DesignPattern;

import static com.gildedrose.item.ItemFactory.MAX_QUALITY_VALUE;
import static com.gildedrose.item.ItemFactory.MIN_QUALITY_VALUE;
import static com.gildedrose.documentation.Type.TEMPLATE_METHODE;

@DesignPattern(TEMPLATE_METHODE)
public abstract class UpdatableItem{

    Item item;

    public UpdatableItem(Item item) {
        this.item = item;
    }

    public void update() {
        updateSellIn();
        updateQuality();
        checkValues();
    }

    private void checkValues() {
        if(isQualityBelowMinValue())
            this.item.quality = MIN_QUALITY_VALUE;
    }

    private boolean isQualityBelowMinValue() {
        return this.item.quality < MIN_QUALITY_VALUE;
    }

    abstract void updateQuality();

    abstract void updateSellIn();

    void increaseQuality() {
        this.item.quality++;
    }

    void decreaseQuality() {
        this.item.quality--;
    }

    int decreaseSeelIn() {
        return this.item.sellIn--;
    }

    boolean isQualityBelowMax() {
        return this.item.quality < MAX_QUALITY_VALUE;
    }

    void increaseQualityIfBelowMax() {
        if (isQualityBelowMax()) {
            increaseQuality();
        }
    }
    boolean isSellInBelow(int sellIn) {
        return this.item.sellIn < sellIn;
    }

    void setQualityTo0() {
        this.item.quality = MIN_QUALITY_VALUE;
    }
}
