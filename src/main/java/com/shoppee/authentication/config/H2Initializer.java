package com.shoppee.authentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shoppee.authentication.entity.ShoppeeUser;
import com.shoppee.authentication.service.ShoppeeUserRepoService;

@Configuration
public class H2Initializer {
	
	@Autowired
	ShoppeeUserRepoService userRepo;

	/*
	 * 
	 * Load users when Spring Boot app is successfully started
	 * 
	 */
	@EventListener(ApplicationReadyEvent.class)

	public void addUsers() throws JsonProcessingException {
		userRepo.addUserService(new ShoppeeUser("a@gmail.com","Ankush", "password"));
		userRepo.addUserService(new ShoppeeUser( "n@gmail.com","Nitin", "password"));
	}

}
