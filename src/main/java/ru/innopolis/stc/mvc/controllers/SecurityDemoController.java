package ru.innopolis.stc.mvc.controllers;

import java.security.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SecurityDemoController {

  @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
  public ModelAndView accesssDenied(Principal user) {
    ModelAndView model = new ModelAndView();

    if (user != null) {
      model.addObject("errorMsg", user.getName() + " нет доступа или прав к этой странице!");
    } else {
      model.addObject("errorMsg", "У вас нет доступа к этой странице или недостаточно привелегий");
    }
    model.setViewName("accessDenied");
    return model;
  }

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public String mainPage() {
    SecurityContext context = SecurityContextHolder.getContext();
    Authentication auth = context.getAuthentication();
    return "user";
  }

  @RequestMapping(value = "/admin", method = RequestMethod.GET)
  public String adminPage() {
    return "admin";
  }

  @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
  public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
    ModelAndView model = new ModelAndView();
    if (error != null && error.isEmpty()) {
      model.addObject("error", "Invalid or not correct username or password!");
    }
    model.setViewName("login");
    return model;
  }

}