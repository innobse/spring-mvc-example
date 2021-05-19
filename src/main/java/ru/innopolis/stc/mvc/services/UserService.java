package ru.innopolis.stc.mvc.services;

import java.util.Collection;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.innopolis.stc.mvc.exceptions.CreateObjectException;
import ru.innopolis.stc.mvc.repositories.UserDao;
import ru.innopolis.stc.mvc.repositories.entities.User;
import ru.innopolis.stc.mvc.security.MyUserDetails;

public class UserService implements UserDetailsService {

  private final UserDao repository;

  public UserService(UserDao repository) {
    this.repository = repository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final User userByLogin = getUserByUsername(username);
    return userByLogin == null ? null : new MyUserDetails(userByLogin);
  }

  public User getUserByUsername(String username) {
    return repository.getUserByLogin(username);
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public Collection<User> getAllUsers() {
    return repository.getAll();
  }

  public User createNewUser(User newUser) {
    try {
      return repository.addUser(newUser);
    } catch (Exception err) {
      throw new CreateObjectException("Пользователь", err);
    }

  }
}
