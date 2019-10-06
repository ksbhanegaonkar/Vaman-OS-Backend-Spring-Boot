package com.vamanos;

import javax.servlet.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vamanos.filter.CORSResponseFilter;
import com.vamanos.repo.RoleRepository;
import com.vamanos.repo.UserRepository;

@SpringBootApplication
public class VamanOsBackendSpringBootApplication implements CommandLineRunner 
{
	private static final Logger log = LoggerFactory.getLogger(VamanOsBackendSpringBootApplication.class);

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(VamanOsBackendSpringBootApplication.class, args);
	}
	
	@Bean
	public Filter compressFilter() {
	    CORSResponseFilter corsFilter = new CORSResponseFilter();
	    return corsFilter;
	}
	
	  @Override public void run(String... args) {
	  
	  log.info("StartApplication..."); 
	  System.out.println("role is : "+roleRepository.findByName("role_admin"));
	 
		/*
		 * Users userNew = new Users();
		 * 
		 * userNew.setUsername("kedar1"); userNew.setPassword("kedar1");
		 * userNew.setEmail("kedar1@test.com"); Permissions permissions = new
		 * Permissions(); permissions.setName("can_create_user"); Roles roles = new
		 * Roles(); roles.getPermissions().add(permissions);
		 * userNew.getRoles().add(roles);
		 * 
		 * 
		 * 
		 * userRepository.saveAndFlush(userNew);
		 */
	  
	  }
	  
	 
	 

}
