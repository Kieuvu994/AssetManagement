package CNPMNC.AssetManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import CNPMNC.AssetManagement.model.User;
import CNPMNC.AssetManagement.repository.UserRepository;

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
          user.setUsername(newUser.getUsername());
          user.setPassword(newUser.getPassword());
          user.setDepartmentId(newUser.getDepartmentId());
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
