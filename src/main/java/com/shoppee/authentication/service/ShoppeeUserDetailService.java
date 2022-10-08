package com.shoppee.authentication.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shoppee.authentication.entity.ShoppeeUser;
import com.shoppee.authentication.repository.ShoppeeUserRepo;

@Service
public class ShoppeeUserDetailService implements UserDetailsService {
	
	@Autowired
	ShoppeeUserRepo	 userRepo;

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		
		Optional<ShoppeeUser> shoppeeUser = userRepo.findById(username);
		if(shoppeeUser.isPresent()) {
			return new User(shoppeeUser.get().getEmail() ,shoppeeUser.get().getPassword(),new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("User not found!");
		}
	}

}
