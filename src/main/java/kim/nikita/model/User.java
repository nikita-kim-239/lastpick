package kim.nikita.model;


import java.util.Objects;


public class User extends AbstractBaseEntity {


    private String login;

    private String password;

    private Rank rank;

    public User() {

    }

    public User(String login, String password, Rank rank) {
        this.login = login;
        this.password = password;
        this.rank = rank;
    }

    public User(Integer id, String login, String password, Rank rank) {
        super(id);
        this.login = login;
        this.password = password;
        this.rank = rank;
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

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return login.equals(user.login) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
