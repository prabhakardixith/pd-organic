package com.organic.pdorganic;

import com.organic.pdorganic.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@CrossOrigin(origins = {"https://pd-organic-react.herokuapp.com/","http://localhost:3000"})
public class PdOrganicApplication{
	@Autowired
	UserRepo userRepo ;
	public static void main(String[] args) {
		SpringApplication.run(PdOrganicApplication.class, args);
	}

	public void loadUsers(){

	}
	@GetMapping("/user")
	public List<User> getAllUsers(){
//		System.out.println("get User");
		return userRepo.findAll();
	}

	@PostMapping("/user")
	public User addUser(@RequestBody User user){
		User savedUser = userRepo.save(user);
//		System.out.println(user);
		return savedUser;
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user){
		User updateUser = userRepo.saveAndFlush(user);
		return updateUser;
	}

	@DeleteMapping("/user")
	public void deleteUser(@RequestParam("id") int id){
		userRepo.deleteById(id);
	}

}
