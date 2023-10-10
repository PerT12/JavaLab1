package bo;

import db.UserDB;

public class UserHandler {

    public static User logIn(String username, String password) {
        User loggedIn = UserDB.searchUser(username, password);
        /*if(loggedIn == null) {
            System.out.println("new user");
            UserDB.addUser(username,password);
            loggedIn = new User(username, password, null);
        } else {
            System.out.println("old user");
        }*/
        return loggedIn;
    }
}