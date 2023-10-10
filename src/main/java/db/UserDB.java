package db;

import bo.User;
import java.sql.*;

public class UserDB {
    public static User searchUser(String username, String password) {
        try {
            Connection con = DBManager.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM itemsdb.user WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("username");
                    String pass = rs.getString("password");
                    String info = rs.getString("info");
                    User user = new User(name, pass, info);
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
             PreparedStatement ps = con.prepareStatement("INSERT INTO itemsdb.user (name, password) VALUES (?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
