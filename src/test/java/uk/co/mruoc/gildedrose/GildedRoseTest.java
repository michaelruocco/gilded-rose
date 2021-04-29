package uk.co.mruoc.gildedrose;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

class GildedRoseTest {

    @Test
    void shouldUpdateAllItems() {
        UpdatableItem item1 = mock(UpdatableItem.class);
        UpdatableItem item2 = mock(UpdatableItem.class);
        GildedRose gildedRose = new GildedRose(toArray(item1, item2));

        gildedRose.updateQuality();

        InOrder inOrder = inOrder(item1, item2);
        inOrder.verify(item1).update();
        inOrder.verify(item2).update();
    }

    private UpdatableItem[] toArray(UpdatableItem... items) {
        return items;
    }

}
