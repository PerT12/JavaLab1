package db;

import bo.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ItemDB extends Item {

    public static List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM itemsdb.item");

            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                items.add(new ItemDB(id, name, description, price));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    private ItemDB(int id, String name, String description, double price) {
        super(id, name, description, price);
    }
}