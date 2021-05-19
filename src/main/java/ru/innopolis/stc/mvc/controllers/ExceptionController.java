package ru.innopolis.stc.mvc.controllers;

import java.sql.SQLClientInfoException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.innopolis.stc.mvc.controllers.dto.ExceptionDto;
import ru.innopolis.stc.mvc.exceptions.CreateObjectException;

@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler
  @ResponseBody
  public ResponseEntity<Exception> catchException(Exception err) {
//    return "Произошла ошибка: \"" + err.getMessage() + "\"";
    ResponseEntity<Exception> response = ResponseEntity.status(200).body(err);
    return response;
  }

  @ExceptionHandler
  @ResponseBody
  public ResponseEntity<ExceptionDto> catchCreateException(CreateObjectException err) {

    ExceptionDto exceptionDto = new ExceptionDto(
            err.getMessage(),
            err.getCause() != null ? err.getCause().getMessage() : null);
    ResponseEntity<ExceptionDto> response = ResponseEntity.status(200).body(exceptionDto);
    return response;
  }

  @ExceptionHandler(value = SQLClientInfoException.class)
  public String catchException(SQLClientInfoException err, Model model) {
    //  TODO: логи?
    model.addAttribute("error", "Не могу получить данные для ответа");
    return "error";
  }
}
