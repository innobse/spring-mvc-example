package ru.innopolis.stc.mvc.controllers;

import static java.util.Arrays.asList;

import java.sql.SQLClientInfoException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

  @RequestMapping(value = "/hello/world", method = RequestMethod.GET)
  public String getAll(Model model) {
    model.addAttribute("name", "Spring");
    model.addAttribute("list",
        asList("Бины", "Компоненты", "Сервлеты", "Контроллеры"));
    return "hello";
  }

  @RequestMapping(value = "/want/exception", method = RequestMethod.GET)
  public String exception() throws Exception {
    throw new Exception("Все очень плохо...");
  }

  @RequestMapping(value = "/want/sqlexception", method = RequestMethod.GET)
  public String sqlException() throws SQLClientInfoException {
    throw new SQLClientInfoException();
  }
}
