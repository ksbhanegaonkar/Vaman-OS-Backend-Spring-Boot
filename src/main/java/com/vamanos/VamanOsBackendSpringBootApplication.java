package com.vamanos;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vamanos.entity.Users;
import com.vamanos.repo.UserRepository;

@SpringBootApplication
public class VamanOsBackendSpringBootApplication //implements CommandLineRunner 
{
	private static final Logger log = LoggerFactory.getLogger(VamanOsBackendSpringBootApplication.class);

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(VamanOsBackendSpringBootApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) {
	 * 
	 * log.info("StartApplication..."); Users user =
	 * userRepository.findByUsername("admin");
	 * 
	 * System.out.println("User is :::: "+user);
	 * 
	 * 
	 * 
	 * repository.save(new Book("Java")); repository.save(new Book("Node"));
	 * repository.save(new Book("Python"));
	 * 
	 * System.out.println("\nfindAll()"); repository.findAll().forEach(x ->
	 * System.out.println(x));
	 * 
	 * System.out.println("\nfindById(1L)"); repository.findById(1l).ifPresent(x ->
	 * System.out.println(x));
	 * 
	 * System.out.println("\nfindByName('Node')");
	 * repository.findByName("Node").forEach(x -> System.out.println(x));
	 * }
	 */ 
	 
	 

}
