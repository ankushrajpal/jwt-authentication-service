package com.shoppee.authentication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class ShoppeeUser {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Email
	@NonNull
	private String email;
	@NonNull
	private String username;
	@NonNull
	private String password;
	
}
