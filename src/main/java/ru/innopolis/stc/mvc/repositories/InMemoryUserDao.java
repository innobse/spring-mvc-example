package ru.innopolis.stc.mvc.repositories;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.innopolis.stc.mvc.repositories.entities.User;

public class InMemoryUserDao implements UserDao {

  private static final Logger LOGGER = Logger.getLogger("InMemoryUserDao");

  private final Map<String, User> database;

  public InMemoryUserDao(PasswordEncoder encoder) {
    database = new HashMap<>();
    database.put("admin", new User("admin", encoder.encode("admin"), "ROLE_ADMIN", "ROLE_USER"));
    database.put("user", new User("user", encoder.encode("user"), "ROLE_USER"));
    database.put("guest", new User("guest", encoder.encode("guest"), "ROLE_USER"));
  }

  @Override
  public User addUser(User user) throws Exception {
    throw new SQLException("Упс! Неверный запрос: SELECT OLOLO;");
//    database.put(user.getLogin(), user);
//    return database.get(user.getLogin());
  }

  @Override
  public User getUserByLogin(String userLogin) {
    return database.get(userLogin);
  }

  @Override
  public Collection<User> getAll() {
    return database.values();
  }
}
