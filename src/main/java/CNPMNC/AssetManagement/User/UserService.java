package CNPMNC.AssetManagement.User;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository repository;

  public UserService(UserRepository repo) {
    this.repository = repo;
  }

  public User save(User newUser) {
    return repository.save(newUser);
  }

  public User findById(Integer id) {
    return repository.findById(id).orElseThrow(
        () -> new RuntimeException("User not found"));

  }

  public User editUser(User newUser, Integer id) {
    return repository.findById(id)
        .map(user -> {
          user.setName(newUser.getName());
          user.setEmail(newUser.getEmail());
          return repository.save(user);
        })
        .orElseGet(() -> {
          newUser.setId(id);
          return repository.save(newUser);
        });
  }

  public List<User> getAll() {
    return repository.findAll();
  }
}
