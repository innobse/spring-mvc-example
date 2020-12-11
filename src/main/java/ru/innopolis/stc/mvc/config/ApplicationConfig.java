package ru.innopolis.stc.mvc.config;

import javax.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import ru.innopolis.stc.mvc.repositories.InMemoryUserDao;
import ru.innopolis.stc.mvc.repositories.UserDao;
import ru.innopolis.stc.mvc.security.AuthSuccessHandler;
import ru.innopolis.stc.mvc.security.MyFilter;
import ru.innopolis.stc.mvc.security.PassEncoder;
import ru.innopolis.stc.mvc.services.UserService;

@Configuration
public class ApplicationConfig {

  @Bean
  public PasswordEncoder passEncoder() {
    return new PassEncoder();
  }

  @Bean
  public UserDao inMemoryUserDao(PasswordEncoder encoder) {
    return new InMemoryUserDao(encoder);
  }

  @Bean
  public UserService userService(UserDao dao) {
    return new UserService(dao);
  }

  @Bean
  public AuthenticationSuccessHandler authSuccessHandler(UserDao dao) {
    return new AuthSuccessHandler(dao);
  }

  @Bean
  public Filter myFilter() {
    return new MyFilter();
  }

}
