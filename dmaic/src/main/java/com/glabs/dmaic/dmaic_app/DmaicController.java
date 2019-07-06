package com.glabs.dmaic.dmaic_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.glabs.dmaic.dmaic_app.DmaicRepository;
import com.glabs.dmaic.user.UserRepository;

@RestController

public class DmaicController {
	
@Autowired
private DmaicRepository repository;

@Autowired
private UserRepository userRepository;


public DmaicRepository getRepository() 
{
	return repository;
}
public void setRepository(DmaicRepository repository) {
	this.repository = repository;
}

@GetMapping(value = "/dmaic")
public List<Dmaic> getAllDmaic() {
	return repository.findAll();
}

@PostMapping("/dmaic")
Dmaic createOrSaveDmaic(@RequestBody Dmaic newDmaic) {
	return repository.save(newDmaic);
}

//@GetMapping("/dmaic/{id}")
	//Dmaic getDmaicById(@PathVariable Lo)
}