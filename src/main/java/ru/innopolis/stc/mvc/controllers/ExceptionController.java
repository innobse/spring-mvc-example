package ru.innopolis.stc.mvc.controllers;

import java.sql.SQLClientInfoException;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler
  @ResponseBody
  public ResponseEntity<Exception> catchException(Exception err) {
//    return "Произошла ошибка: \"" + err.getMessage() + "\"";
    ResponseEntity<Exception> response = ResponseEntity.status(200).body(err);
    return response;
  }

  @ExceptionHandler(value = SQLClientInfoException.class)
  public String catchException(SQLClientInfoException err, Model model) {
    //  TODO: логи?
    model.addAttribute("error", "SQLClientInfoException");
    return "error";
  }
}
