package container;

import model.UserAccount;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<UserAccount> users = new ArrayList<>();

    static {
        users.add(new UserAccount("ist1997", "1234"));
        users.add(new UserAccount("qwerty", "1111"));
        users.add(new UserAccount("admin", "admin"));
    }
}
