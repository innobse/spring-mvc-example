package ru.innopolis.stc.mvc.repositories;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.innopolis.stc.mvc.repositories.entities.User;

public class InMemoryUserDao implements UserDao {

  private final Map<String, User> database;

  public InMemoryUserDao(PasswordEncoder encoder) {
    database = new HashMap<>();
    database.put("admin", new User("admin", encoder.encode("admin"), "ROLE_ADMIN", "ROLE_USER"));
    database.put("user", new User("user", encoder.encode("user"), "ROLE_USER"));
    database.put("guest", new User("guest", encoder.encode("guest"), "ROLE_USER"));
  }

  @Override
  public void addUser(User user) {
    database.put(user.getLogin(), user);
  }

  @Override
  public User getUserByLogin(String userLogin) {
    return database.get(userLogin);
  }
}
