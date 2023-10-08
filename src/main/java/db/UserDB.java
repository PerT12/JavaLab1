package db;

import bo.Item;
import bo.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDB {
    public static User searchUser(String username, String password) {

        try {
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            String query = "SELECT * FROM itemsdb.user where name = '"
                    + username + "' AND password = '" + password + "'";
            ResultSet rs = st.executeQuery(query);
            if (rs == null) return null;

            while (rs.next()) {
                String name = rs.getString("username");
                String pass = rs.getString("password");
                String info = rs.getString("info");
                User user = new User(name, pass, info);
                System.out.println(name);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addUser(String username, String password) {
        try {
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            String query = "INSERT INTO itemsdb.user (name, password) VALUES " +
                    "('" + username + "', '" + password + "')";
            System.out.println("Här kan det gå snett");
            st.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }
}
