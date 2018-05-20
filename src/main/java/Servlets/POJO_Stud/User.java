package Servlets.POJO_Stud;

public class User {
    private  int id;
    private  String login;
    private  String password;
    private  int role;

    public User(int id, String login, String passwordHash, int role) {
        this.id = id;
        this.login = login;
        this.password = passwordHash;
        this.role = role;
    }

    public User(String login, String password, int role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPasswordHash(String passwordHash) {
        this.password = passwordHash;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
