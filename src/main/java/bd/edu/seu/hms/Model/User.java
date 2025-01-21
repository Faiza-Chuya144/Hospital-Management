package bd.edu.seu.hms.Model;

public class User {
    private String email;
    private String name;
    private String password;
    private String user;


    public User(String email, String name, String password,String user) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.user = user;
    }

    public User(String name, String password,String user) {
        this.name = name;
        this.password = password;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
