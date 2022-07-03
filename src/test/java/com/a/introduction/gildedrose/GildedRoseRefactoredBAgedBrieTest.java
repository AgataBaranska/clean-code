package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseRefactoredBAgedBrieTest {


	public static final String AGED_BRIDE = "Aged Brie";
	public static final int UNEXPIRED_SELL_IN = 4;
	public static final int QUALITY = 3;
	public static final int EXPIRED_SELLIN = -1;
	public static final int MAXIMUM_QUALITY = 50;

	@Test
	public void unexpiredAgedBrieQualityIncreasesBy1() {
		//setup
		GildedRose app = createGildedRose(AGED_BRIDE, UNEXPIRED_SELL_IN, QUALITY);
		//invoke
		app.updateQuality();
		//verify
		Item actual = app.items[0];

		Item expected = new Item(AGED_BRIDE, UNEXPIRED_SELL_IN -1,QUALITY+1);
		assertItem(actual, expected.name, expected.sellIn, expected.quality);
	}


	@Test
	public void expiredAgedBrieItemQualityIncreasesBy2() {
		GildedRose app = createGildedRose(AGED_BRIDE, EXPIRED_SELLIN, QUALITY);
		app.updateQuality();
		//verify
		Item actual = app.items[0];

		Item expected = new Item(AGED_BRIDE,EXPIRED_SELLIN-1,QUALITY+2);
		assertItem(actual, expected.name, expected.sellIn, expected.quality);

	}

	@Test
	public void unexpiredAgedBrie_qualityDoesNotGoBeyondMaximum() {
		GildedRose app = createGildedRose(AGED_BRIDE,UNEXPIRED_SELL_IN , MAXIMUM_QUALITY);
		app.updateQuality();

		Item actual = app.items[0];

		Item expected = new Item(AGED_BRIDE, UNEXPIRED_SELL_IN -1,MAXIMUM_QUALITY);
		assertItem(actual, expected.name, expected.sellIn, expected.quality);

	}

	private GildedRose createGildedRose(String agedBride, int sellIn, int quality) {
		Item item = new Item(agedBride, sellIn, quality);
		Item[] items = new Item[]{item};
		return new GildedRose(items);
	}

	private void assertItem(Item actual, String name, int sellIn, int quality) {
		assertEquals(name, actual.name);
		assertEquals(sellIn, actual.sellIn);
		assertEquals(quality, actual.quality);
	}
}
