package com.gildedrose;

import org.junit.Test;

import static com.gildedrose.item.ItemFactory.*;
import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    public static final int OUTDATED = 0;

    @Test
    // At the end of each day our system lowers both values for every item
    public void can_lower_item_quality_and_sellIn_at_end_of_day() {
        //Given
        GildedRose gildedRose = new GildedRose(new Item[] { new ItemBuilder()
                .withQuality(10)
                .withSellIn(10)
                .build()
        });
        //When
        gildedRose.updateQuality();
        //Then
        Item result = firstResultItem(gildedRose);
        assertEquals(9, result.quality);
        assertEquals(9, result.sellIn);
    }

    @Test
    // Once the sell in date has passed, Quality degrades twice as fast
    public void can_lower_twice_as_fast_item_quality_if_sellin_passed() {
        //Given
        GildedRose app = new GildedRose(new Item[] { new ItemBuilder()
                .withQuality(10)
                .withSellIn(OUTDATED)
                .build()
        });
        //When
        app.updateQuality();
        //Then
        Item result = firstResultItem(app);
        assertEquals(8, result.quality);
        assertEquals(-1, result.sellIn);
    }

    @Test
    // The Quality of an item is never negative
    public void item_quality_never_below_zero() {
        //Given
        GildedRose app = new GildedRose(new Item[] { new ItemBuilder()
                .withQuality(0)
                .withSellIn(10)
                .build()
        });
        //When
        app.updateQuality();
        //Then
        Item result = firstResultItem(app);
        assertEquals(0, result.quality);
    }

    @Test
    // "Aged Brie" actually increases in Quality the older it gets
    public void Aged_Brie_item_increase_quality_the_older_it_gets() {
        //Given
        GildedRose app = new GildedRose(new Item[] { new ItemBuilder()
                .withName(AGED_BRIE)
                .withQuality(10)
                .withSellIn(10)
                .build()
        });
        //When
        app.updateQuality();
        //Then
        Item result = firstResultItem(app);
        assertEquals(11, result.quality);
    }

    @Test
    // The Quality of an item is never more than 50
    public void item_quality_increase_never_more_than_50() {
        //Given
        GildedRose app = new GildedRose(new Item[] { new ItemBuilder()
                .withName(AGED_BRIE)
                .withQuality(50)
                .withSellIn(10)
                .build()
        });
        //When
        app.updateQuality();
        //Then
        Item result = firstResultItem(app);
        assertEquals(50, result.quality);
    }

    @Test
    // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    public void sulfuras_item_never_has_to_be_sold_or_decrease_quality() {
        //Given
        GildedRose app = new GildedRose(new Item[] { new ItemBuilder()
                .withName(SULFURAS)
                .withQuality(10)
                .withSellIn(10)
                .build()
        });
        //When
        app.updateQuality();
        //Then
        Item result = firstResultItem(app);
        assertEquals(10, result.quality);
        assertEquals(10, result.quality);
    }

    @Test
    // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    public void sulfuras_has_always_80_quality() {
        //Given
        GildedRose app = new GildedRose(new Item[] { new ItemBuilder()
                .withName(SULFURAS)
                .withQuality(80)
                .withSellIn(10)
                .build()
        });
        //When
        app.updateQuality();
        //Then
        Item result = firstResultItem(app);
        assertEquals(80, result.quality);
    }



    @Test
    //  "Backstage passes" actually increases in Quality the older it gets
    //  Quality increases by 2 when there are 10 days or less
    public void backstage_passes_item_increase_by_2_quality_when_they_are_10_or_less_days_left() {
        //Given
        GildedRose app = new GildedRose(new Item[] { new ItemBuilder()
                .withName(BACKSTAGE)
                .withQuality(10)
                .withSellIn(10)
                .build()
        });
        //When
        app.updateQuality();
        //Then
        Item result = firstResultItem(app);
        assertEquals(12, result.quality);
    }

    @Test
    //" Backstage passes" actually increases in Quality the older it gets
    //  Quality increases by 3 when there are 5 days or less
    public void backstage_passes_item_increase_by_2_quality_when_they_are_3_or_less_days_left() {
        //Given
        GildedRose app = new GildedRose(new Item[] { new ItemBuilder()
                .withName(BACKSTAGE)
                .withQuality(10)
                .withSellIn(5)
                .build()
        });
        //When
        app.updateQuality();
        //Then
        Item result = firstResultItem(app);
        assertEquals(13, result.quality);
    }

    @Test
    // "Conjured" items degrade in Quality twice as fast as normal items
    public void can_degrade_conjured_twice_as_fast_as_normal_item_for_sellIn_positif() {
        //Given
        GildedRose app = new GildedRose(new Item[] { new ItemBuilder()
                .withName(CONJURED)
                .withQuality(10)
                .withSellIn(5)
                .build()
        });
        //When
        app.updateQuality();
        //Then
        Item result = firstResultItem(app);
        assertEquals(8, result.quality);
    }

    @Test
    // "Conjured" items degrade in Quality twice as fast as normal items
    public void can_degrade_conjured_twice_as_fast_as_normal_item_for_sellIn_negatif() {
        //Given
        GildedRose app = new GildedRose(new Item[] { new ItemBuilder()
                .withName(CONJURED)
                .withQuality(10)
                .withSellIn(OUTDATED)
                .build()
        });
        //When
        app.updateQuality();
        //Then
        Item result = firstResultItem(app);
        assertEquals(6, result.quality);
    }

    private Item firstResultItem(GildedRose app) {
        return app.getItem(0);
    }

}
