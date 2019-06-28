package com.glabs.dmaic.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

@Autowired
private UserRepository repository;

public UserRepository getRepository() {
	return repository;
}

public void setRepository(UserRepository repository) {
	this.repository = repository;
}

@GetMapping(value = "/users")
public List<User> getAllUsers() {
	return repository.findAll();
}

@PostMapping("/users")
User createOrSaveUser(@RequestBody User newUser) {
	return repository.save(newUser);
}

@GetMapping("/users/{id}")
	User getUserById(@PathVariable Long id) {
	return repository.findById(id).get();
}

@PutMapping("/users/{id}")
User updateUser(@RequestBody User newUser, @PathVariable Long id) {
	 
    return repository.findById(id).map(user -> {
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setPhoneNumber(newUser.getPhoneNumber());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        return repository.save(user);
    }).orElseGet(() -> {
        newUser.setId(id);
        return repository.save(newUser);
    });
}

@DeleteMapping("/users/{id}")
void deleteUser(@PathVariable Long id) {
    repository.deleteById(id);
}
}
