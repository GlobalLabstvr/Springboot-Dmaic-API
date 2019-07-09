package com.glabs.dmaic.dmaic_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.glabs.dmaic.dmaic_app.DmaicRepository;

@RestController

public class DmaicController {
	
@Autowired
private DmaicRepository dmaicRepository;

@Autowired
//private UserRepository userRepository;


public DmaicRepository getRepository() 
{
	return dmaicRepository;
}
public void setRepository(DmaicRepository repository) {
	this.dmaicRepository = repository;
}

@GetMapping(value = "/dmaic")
public List<Dmaic> getAllDmaic() {
	return dmaicRepository.findAll();
}

@PostMapping("/dmaic")
Dmaic createOrSaveDmaic(@RequestBody Dmaic newDmaic) {
	return dmaicRepository.save(newDmaic);
}
 
}