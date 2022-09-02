package com.organic.pdorganic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PdOrganicApplication implements CommandLineRunner{
	Set<User> userList ;

	int count ;
	public static void main(String[] args) {
		SpringApplication.run(PdOrganicApplication.class, args);
	}

	public void loadUsers(){

	}
	@GetMapping("/user")
	public Set<User> getAllUsers(){
//		System.out.println("get User");
		return userList;
	}

	@PostMapping("/user")
	public User addUser(@RequestBody User user){
		user.setUserId(count+1);
		userList.add(user);
//		System.out.println(user);
		return user;
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user){
		userList.add(user);
		return user;
	}

	@DeleteMapping("/user")
	public void deleteUser(@RequestBody int id){
		userList = userList.stream().filter(f -> f.userId != id).collect(Collectors.toSet());
	}

	@Override
	public void run(String... args) throws Exception {
		userList = new LinkedHashSet<>();
		userList.add(new User(1,"prabhakar dixit","pd@gmail.com"));
		userList.add(new User(2,"diwakar dixit","dd@gmail.com"));
		userList.add(new User(3,"nalu dixit","nd@gmail.com"));
		userList.add(new User(4,"asha dixit","ad@gmail.com"));
		userList.add(new User(4,"anu patil","ap@gmail.com"));

		count = userList.size();
	}
}
