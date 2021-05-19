package ru.innopolis.stc.mvc.controllers;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.stc.mvc.controllers.dto.UserDto;
import ru.innopolis.stc.mvc.repositories.entities.User;
import ru.innopolis.stc.mvc.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/{username}", method = RequestMethod.GET)
  public UserDto getUsers(@PathVariable String username) {
    final User userByUsername = userService.getUserByUsername(username);
    if (userByUsername == null) return null;
    return new UserDto(userByUsername.getLogin(), userByUsername.getRoles());
  }

  @GetMapping("/")
  public Collection<UserDto> getUsers() {
    final Collection<User> allUsers = userService.getAllUsers();
    return allUsers.stream()
        .map(user -> new UserDto(user.getLogin(), user.getRoles()))
        .collect(Collectors.toList());
  }

  @PostMapping("/")
  public UserDto addUser(@RequestBody UserDto userDto) {
    User newUser = new User(userDto.getUsername(), "123", userDto.getRoles());
    newUser = userService.createNewUser(newUser);
    return new UserDto(newUser.getLogin(), newUser.getRoles());
  }

}
