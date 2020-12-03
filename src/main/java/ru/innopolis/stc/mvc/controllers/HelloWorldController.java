package ru.innopolis.stc.mvc.controllers;

import static java.util.Arrays.asList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

  @RequestMapping(value = "/hello/world", method = RequestMethod.GET)
  public String getAll(Model model) {
    model.addAttribute("name", "Spring");
    model.addAttribute("list",
        asList("Бины", "Компоненты", "Сервлеты", "Контроллеры"));
    return "hello";
  }
}
