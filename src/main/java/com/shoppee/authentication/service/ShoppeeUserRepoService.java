package com.shoppee.authentication.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppee.authentication.entity.ShoppeeUser;
import com.shoppee.authentication.exceptions.DuplicateUserException;
import com.shoppee.authentication.exceptions.UserNotFoundException;
import com.shoppee.authentication.repository.ShoppeeUserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShoppeeUserRepoService {

	
	@Autowired
	ObjectMapper mapper;
	@Autowired
	ShoppeeUserRepo userRepo;

	/**
	 * This method returns all the users available in the user table
	 * 
	 * @return List<User>
	 * @throws JsonProcessingException
	 */
	public List<ShoppeeUser> getAllUsersService() throws JsonProcessingException {
		return userRepo.findAll();

	}

	/**
	 * This method deletes the user associated with specified email.
	 * 
	 * @param email
	 */
	@Transactional
	public void deleteUserByEmailService(String email) {
		int deleted;

		deleted = userRepo.removeById(email);

		if (deleted == 0) {
			log.error("User Not Found with specified email");
			throw new UserNotFoundException();
		}

	}

	/**
	 * This method returns the user associated with specified email
	 * 
	 * @param email
	 * @return user
	 * @throws JsonProcessingException
	 */
	public ShoppeeUser getUserByEmailService(String email) throws JsonProcessingException {
		Optional<ShoppeeUser> user = userRepo.findById(email);
		if (!user.isPresent()) {
			log.error("User Not Found with specified Email");
			throw new UserNotFoundException();
		} else {
			return user.get();
		}

	}

	/**
	 * This method creates a user in the database and returns the user object
	 * created .
	 * 
	 * @param user
	 * @return user(User that is created in the database)
	 * @throws JsonProcessingException
	 */
	public ShoppeeUser addUserService(ShoppeeUser user)  {

		Optional<ShoppeeUser> checkUser = userRepo.findById(user.getEmail());

		if (!checkUser.isPresent()) {
			return userRepo.save(user);

		} else {
			log.error("User with specified email already Exixts");
			throw new DuplicateUserException();
		}

	}

}
