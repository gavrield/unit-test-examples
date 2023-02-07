package testingil.unittesting.examples.demos.d04.characterization;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GildedRoseTests {

    @Test
    @Disabled
    public void approvals() {
        TestLogger logger = new TestLogger();

        List<Item> items = List.of(
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6));

        var item_array = items.stream().toArray(Item[]::new);
        GildedRose gildedRose = new GildedRose(item_array);

        int days = 2;

        for (int i = 0; i < days; i++) {
            logger.append("-------- day " + i + " --------");
            logger.append("name, sellIn, quality");
            items.forEach(item -> {
                logger.append(item.toString());
            });
            gildedRose.updateQuality();
        }
        Approvals.verify(logger.getAll());
    }
}
