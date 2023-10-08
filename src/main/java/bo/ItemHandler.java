package bo;

import ui.ItemInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemHandler {

    public static List<ItemInfo> getAllItems() {
        List<Item> list = Item.getAllItems();
        ArrayList<ItemInfo> items = new ArrayList<>();
        for(Iterator it = list .iterator(); it.hasNext();) {
            Item item = (Item) it.next();
            items.add(new ItemInfo(item.getId(), item.getName(), item.getDescription(), item.getPrice()));
        }
        return items;
    }
}