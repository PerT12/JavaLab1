package bo;

import ui.ItemInfo;
import java.util.ArrayList;
import java.util.List;

public class ItemHandler {

    public static List<ItemInfo> getAllItems() {
        List<Item> list = Item.getAllItems();
        ArrayList<ItemInfo> items = new ArrayList<>();
        for(Item item : list) {
            items.add(new ItemInfo(item.getId(), item.getName(), item.getDescription(), item.getPrice()));
        }
        return items;
    }
}