package com.organic.pdorganic;

//import com.organic.pdorganic.repo.UserRepo;
//import com.organic.pdorganic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableCaching
@CrossOrigin(origins = {"https://pd-organic-react.herokuapp.com/","http://localhost:3000"})
public class PdOrganicApplication{


	public static void main(String[] args) {
		SpringApplication.run(PdOrganicApplication.class, args);
	}

}
