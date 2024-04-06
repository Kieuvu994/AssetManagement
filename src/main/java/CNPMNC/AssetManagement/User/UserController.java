package CNPMNC.AssetManagement.User;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;

@RestController
public class UserController {
  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping("/users")
  List<User> getUser() {
    return service.getAll();
  }

  @PostMapping("/users")
  @NonNull
  User newUser(@RequestBody User newUser) {
    return service.save(newUser);
  }

  @GetMapping("/users/{id}")
  User one(@PathVariable Integer id) {
    return service.findById(id);
  }

  @PutMapping("/users/{id}")
  User editUser(@RequestBody User newUser, @PathVariable Integer id) {
    return service.editUser(newUser, id);
  }

}
