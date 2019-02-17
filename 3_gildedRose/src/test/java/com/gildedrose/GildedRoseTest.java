package com.gildedrose;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GildedRoseTest
{

    @Test
    void updateQuality()
    {
        Item standardItem = new Item("Salami", 5, 10);
        GildedRose app = new GildedRose(new Item[]{standardItem});
        app.updateQuality();
        assertEquals(standardItem.sellIn, 4);
    }
}