package com.glabs.dmaic.dmaic_app;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.glabs.dmaic.dmaic_app.DmaicRepository;
import com.glabs.dmaic.exception.ResourceNotFoundException;

import com.glabs.dmaic.user.UserRepository;



@RestController

public class DmaicController {
	
@Autowired
private DmaicRepository dmaicRepository;

@Autowired
private UserRepository userRepository;


@GetMapping(value = "/dmaic")
public List<Dmaic> getAllDmaic() {
	return dmaicRepository.findAll();
}

//@PostMapping("/dmaic")
//Dmaic createOrSaveDmaic(@RequestBody Dmaic newDmaic) {
	//return dmaicRepository.save(newDmaic);
	
	//}
 
@PostMapping("/dmaic/{userId}")
public Dmaic createDmaic(
		@PathVariable(value = "userId") Long userId,
		@Valid @RequestBody Dmaic dmaic) {
	
	return userRepository.findById(userId).map(user -> {
		dmaic.setUser(user);
		return dmaicRepository.save(dmaic);
	}).orElseThrow(() -> new ResourceNotFoundException("userId " + userId + " not found"));
}

@PutMapping("/dmaic/{id}")
Dmaic updateDmaic(@RequestBody Dmaic newDmaic, @PathVariable Long id) {
	 
    return dmaicRepository.findById(id).map(dmaic -> {
        dmaic.setDefine(newDmaic.getDefine());
        dmaic.setMeasure(newDmaic.getMeasure());
        dmaic.setAnalyse(newDmaic.getAnalyse());
        dmaic.setImplement(newDmaic.getImplement());
        dmaic.setControl(newDmaic.getControl());
        return dmaicRepository.save(dmaic);
    }).orElseGet(() -> {
        newDmaic.setId(id);
        return dmaicRepository.save(newDmaic);
    });
}

@DeleteMapping("/dmaic/{id}")
void deleteDmaic(@PathVariable Long id) {
	dmaicRepository.deleteById(id);
}
}