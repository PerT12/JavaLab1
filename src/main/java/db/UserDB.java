package db;

import bo.Item;
import bo.User;
import ui.ItemInfo;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public class UserDB {
    public static User searchUser(String username, String password) {
        try {
            Connection con = DBManager.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM itemsdb.user WHERE name = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String pass = rs.getString("password");
                    User user = new User(name, pass, "");
                    System.out.println(name);
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addUser(String username, String password) {
        try {Connection con = DBManager.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO itemsdb.user (username, password) VALUES (?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<ItemInfo> getCart(String username, String password, List<ItemInfo> shoppingCart) {
        try {Connection con = DBManager.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cart INNER JOIN user ON cart.userId = user.id WHERE user.username = ? AND user.password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("user_id");
                    System.out.println("id blev " + id);
                    for(int i = 1; i < 6;i++){
                        int ware = rs.getInt("ware" + i);
                        System.out.println("inne i for");
                        if(ware > 0){
                            System.out.println("inne i if");
                            PreparedStatement ps2 = con.prepareStatement("SELECT * FROM itemsdb WHERE id = ?");
                            ps2.setString(1, Integer.toString(i));
                            try (ResultSet rs2 = ps2.executeQuery()) {
                                String name = rs2.getString("name");
                                int itemId = rs2.getInt("id");
                                String description = rs2.getString("description");
                                double price = rs2.getDouble("price");
                                System.out.println("namnet är" + name);
                                shoppingCart.add(new ItemInfo(itemId, name, description, price));
                            }
                        }
                    }
                    return shoppingCart;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
