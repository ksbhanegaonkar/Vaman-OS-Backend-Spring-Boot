package com.vamanos;

import javax.servlet.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vamanos.entity.AppInstanceData;
import com.vamanos.entity.AppInstancePayload;
import com.vamanos.entity.GlobalApps;
import com.vamanos.entity.PersonalApps;
import com.vamanos.entity.TeamApps;
import com.vamanos.entity.Teams;
import com.vamanos.entity.UserTeamRelation;
import com.vamanos.filter.CORSResponseFilter;
import com.vamanos.repo.AppInstanceDataRepository;
import com.vamanos.repo.AppInstancePayloadRepository;
import com.vamanos.repo.GlobalAppsRepository;
import com.vamanos.repo.PersonalAppsRepository;
import com.vamanos.repo.TeamAppsRepository;
import com.vamanos.repo.TeamsRepository;
import com.vamanos.repo.UserTeamRelationRepository;

@SpringBootApplication
public class VamanOsBackendSpringBootApplication implements CommandLineRunner 
{
	private static final Logger log = LoggerFactory.getLogger(VamanOsBackendSpringBootApplication.class);

	@Autowired
	private PersonalAppsRepository appRepo;


	public static void main(String[] args) {
		SpringApplication.run(VamanOsBackendSpringBootApplication.class, args);
	}
	
	@Bean
	public Filter compressFilter() {
	    CORSResponseFilter corsFilter = new CORSResponseFilter();
	    return corsFilter;
	}
	
	  @Override 
	  public void run(String... args) {
		  
		  System.out.println("Saving data...");
		  PersonalApps app = new PersonalApps();
		  app.setUserId(555);
		  app.setAppId(888);
		  appRepo.save(app);
		  System.out.println("Saving completed...");

	  }

}
