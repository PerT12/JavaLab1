package db;

import bo.User;
import java.sql.*;

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
                    System.out.println("Existing user " +name);
                    return user;
                }else {
                    addUser(username,password);
                    System.out.println("New user " + username);
                    return new User(username, password, "");
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
