package com.shoppee.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppee.authentication.entity.ShoppeeUser;
import com.shoppee.authentication.model.JwtRequest;
import com.shoppee.authentication.model.JwtResponse;
import com.shoppee.authentication.service.ShoppeeUserDetailService;
import com.shoppee.authentication.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class JwtController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	ShoppeeUserDetailService userDetailService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	
	
	@RequestMapping("/token")
	public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		
		log.info("Jwt Request : "+ jwtRequest);
		
		try {
			this.authenticationManager
			.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
			
		}catch (UsernameNotFoundException unfe) {
			unfe.printStackTrace();
			throw new Exception("Username Not Found Exception");
			
		}catch(BadCredentialsException bce) {
			bce.printStackTrace();
			throw new Exception("Bad Credentials Exception");
			
		}
		
		// If the user is authenticated successfully generate and send the token.
		User user=userDetailService.loadUserByUsername(jwtRequest.getUsername());
		String token=jwtUtil.generateToken(user);
		return ResponseEntity.ok(new JwtResponse(token));
		
	}

}
