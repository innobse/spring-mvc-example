package ru.innopolis.stc.mvc.security;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import ru.innopolis.stc.mvc.config.Settings;
import ru.innopolis.stc.mvc.repositories.entities.User;

public class MyFilter implements Filter {

  public static final Logger LOGGER = Logger.getLogger("MyFilter");

  private final String targetBlockUser;

  public MyFilter(Settings settings) {
    targetBlockUser = settings.getTargetUserForBlock();
    LOGGER.info(">>> DatabaseUrl: " + settings.getDatabaseUrl());
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    final User user = (User) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");

    if (user != null && user.getLogin().equals(targetBlockUser)) return;

    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {

  }
}
