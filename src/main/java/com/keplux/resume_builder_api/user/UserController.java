package com.keplux.resume_builder_api.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/user/{id}")
  public User getById(@PathVariable Long id) {
    return userService.getById(id);
  }

  @GetMapping("/user")
  public List<User> getAll() {
    return userService.getAll();
  }

  @PostMapping("/user")
  public User create(@RequestBody User user) {
    return userService.create(user);
  }

  @PutMapping("/user/{id}")
  public User update(@RequestBody User user, @PathVariable Long id) {
    return userService.update(user, id);
  }

  @DeleteMapping("/user/{id}")
  public void delete(@PathVariable Long id) {
    userService.delete(id);
  }
}
