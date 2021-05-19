package ru.innopolis.stc.mvc.repositories;

import java.util.Collection;
import ru.innopolis.stc.mvc.repositories.entities.User;

public interface UserDao {

  User addUser(User user) throws Exception;
  User getUserByLogin(String userLogin);
  Collection<User> getAll();
}
