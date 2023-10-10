package bo;

import db.UserDB;

public class UserHandler {

    public static User logIn(String username, String password) {
        User loggedIn = UserDB.searchUser(username, password);
        return loggedIn;
    }
}