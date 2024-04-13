package CNPMNC.AssetManagement;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import CNPMNC.AssetManagement.User.User;
import CNPMNC.AssetManagement.User.UserRepository;
@CrossOrigin("*")
@RestController
public class UserController {
	private final UserRepository repository;
	
	public UserController(UserRepository repo)
	{
		this.repository = repo;
	}
	
	@GetMapping("/users")
	 List<User> getUser()
	{
		// process
		return this.repository.findAll();
	}
	
	@PostMapping("/users")
	  User newUser(@RequestBody User newUser) {
	    return repository.save(newUser);
	  }
	
	 @GetMapping("/users/{id}")
	  User one(@PathVariable Integer id) {
	    return repository.findById(id)
	      .orElseThrow();
	  }
	 
	 @PutMapping("/users/{id}")
	  User editUser(@RequestBody User newUser, @PathVariable Integer id) {
	    
	    return repository.findById(id)
	      .map(employee -> {
	        employee.setName(newUser.getName());
	        employee.setEmail(newUser.getEmail());
	        return repository.save(employee);
	      })
	      .orElseGet(() -> {
	    	  newUser.setId(id);
	        return repository.save(newUser);
	      });
	  }

}
