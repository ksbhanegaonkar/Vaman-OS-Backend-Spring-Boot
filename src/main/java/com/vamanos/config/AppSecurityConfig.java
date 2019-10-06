package com.vamanos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vamanos.encoder.StrongPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	

	@Autowired
	private UserDetailsService userDetailsService;

    @Bean
    public StrongPasswordEncoder passwordEncoder() {
        return new StrongPasswordEncoder();
    }


	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
        http
        //HTTP Basic authentication
        //.csrf().disable()
        .httpBasic()
        .and()
				
				  .authorizeRequests() .antMatchers(HttpMethod.GET,"/addUser").hasRole("role_admin")
				  .antMatchers(HttpMethod.POST,"/books").hasRole("ADMIN") 
				  .antMatchers(HttpMethod.PUT,"/books/**").hasRole("ADMIN") 
				  .antMatchers(HttpMethod.PATCH,"/books/**").hasRole("ADMIN") 
				  .antMatchers(HttpMethod.DELETE,"/books/**").hasRole("ADMIN") 
				  .and().formLogin().disable();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}


	
	
}
