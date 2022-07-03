package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseRefactoredADefaultItemTest {

	public static final int NOT_EXPIRED_SELLIN = 15;
	public static final int DEFAULT_QUALITY = 3;
	public static final String DEFAULT_ITEM = "DEFAULT_ITEM";
	public static final int EXPIREED_SELLIN = -1;

	@Test
	public void testUnexpiredItemQualityDecreasesBy1() {
		//setup
		GildedRose app = getGildedRose(DEFAULT_ITEM, NOT_EXPIRED_SELLIN, DEFAULT_QUALITY);
		//invoke
		app.updateQuality();
		//verify
		Item actual = app.items[0];
		Item expected = new Item(DEFAULT_ITEM,NOT_EXPIRED_SELLIN-1,DEFAULT_QUALITY-1);
		//expected,actual value

		assertItem(actual, expected.name, expected.sellIn, expected.quality);
	}

	@Test
	public void testExpiredDefaultItem_qualityDecreasesBy2() {
		GildedRose app = getGildedRose(DEFAULT_ITEM, EXPIREED_SELLIN, DEFAULT_QUALITY);
		app.updateQuality();
		Item expected = new Item(DEFAULT_ITEM, EXPIREED_SELLIN-1, DEFAULT_QUALITY-2);

		Item actual = app.items[0];
		assertItem(actual, expected.name, expected.sellIn, expected.quality);
	}

	private void assertItem(Item actual, String name, int sellIn, int quality) {
		assertEquals(name, actual.name);
		assertEquals(sellIn, actual.sellIn);
		assertEquals(quality, actual.quality);
	}

	private GildedRose getGildedRose(String itemTyoe, int sellin, int defaultQuality) {
		Item item = new Item(itemTyoe, sellin, defaultQuality);
		Item[] items = new Item[]{item};
		return new GildedRose(items);
	}
}