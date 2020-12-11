package ru.innopolis.stc.mvc.repositories;

import ru.innopolis.stc.mvc.repositories.entities.User;

public interface UserDao {

  void addUser(User user);
  User getUserByLogin(String userLogin);
}
