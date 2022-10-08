package com.shoppee.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shoppee.authentication.entity.ShoppeeUser;

public interface ShoppeeUserRepo extends JpaRepository<ShoppeeUser, String> {

	/*
	 * THis methods deletes a user if present in the user table.
	 * Modifying to return int result(denotes successfully deleted or not)
	 * @param email
	 * @return integer(0/1)
	 */
	@Modifying
	@Query("delete from ShoppeeUser u where u.email=?1")
	public int removeById(String email);
}
