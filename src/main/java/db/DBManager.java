package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {

    private static DBManager instance = null;
    private Connection con = null;

    private static DBManager getInstance() {
        if(instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() {
        String server = "jdbc:mysql://localhost:3306/";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(server, "root", "");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return getInstance().con;
    }
}