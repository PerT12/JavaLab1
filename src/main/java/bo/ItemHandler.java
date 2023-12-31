package bo;

import ui.ItemInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ItemHandler {

    public static Collection<ItemInfo> getItems() {
        Collection c = Item.getItems();
        ArrayList<ItemInfo> items = new ArrayList<>();
        for(Iterator it = c .iterator(); it.hasNext();) {
            Item item = (Item) it.next();
            items.add(new ItemInfo(item.getId(), item.getName(), item.getDescription(), item.getPrice()));
        }
        return items;
    }
}