package ru.innopolis.stc.mvc.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    final User userByLogin = repository.getUserByLogin(username);
    return userByLogin == null ? null : new MyUserDetails(userByLogin);
  }
}
