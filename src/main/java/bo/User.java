package bo;

public class User {
    private String userName;
    private String password;
    private String info;

    public User(String userName, String password, String info) {
        this.userName = userName;
        this.password = password;
        this.info = info;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
