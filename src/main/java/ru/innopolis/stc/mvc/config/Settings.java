package ru.innopolis.stc.mvc.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application.properties")
@Getter
public class Settings {

  @Value("${myconfig.props.ololo}")
  private int prop;

  @Value("${myconfig.props.target-user-for-block:anonymous}")
  private String targetUserForBlock;

  @Value("${myconfig.database.url}")
  private String databaseUrl;

  @Value("${myconfig.database.username}")
  private String username;

  @Value("${myconfig.database.password}")
  private String password;

}