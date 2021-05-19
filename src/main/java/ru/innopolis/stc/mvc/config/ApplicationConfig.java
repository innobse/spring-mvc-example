package ru.innopolis.stc.mvc.config;

import javax.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ru.innopolis.stc.mvc.repositories.InMemoryUserDao;
import ru.innopolis.stc.mvc.repositories.UserDao;
import ru.innopolis.stc.mvc.security.AuthSuccessHandler;
import ru.innopolis.stc.mvc.security.MD5PassEncoder;
import ru.innopolis.stc.mvc.security.MyFilter;
import ru.innopolis.stc.mvc.security.Base64PassEncoder;
import ru.innopolis.stc.mvc.services.UserService;

@Configuration
public class ApplicationConfig {

  @Bean("passEncoder")
  @Profile("!md5")
  public PasswordEncoder base64PassEncoder() {
    return new Base64PassEncoder();
  }

  @Bean("passEncoder")
  @Profile("md5")
  public PasswordEncoder md5PassEncoder() {
    return new MD5PassEncoder();
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
  public Filter myFilter(Settings settings) {
    return new MyFilter(settings);
  }

}
