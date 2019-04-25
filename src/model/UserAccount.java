package model;

import java.util.Objects;

public final class UserAccount {
    private String login;
    private String password;

    public UserAccount(String userName, String password) {
        this.login = userName;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return login.equals(that.login) && password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
