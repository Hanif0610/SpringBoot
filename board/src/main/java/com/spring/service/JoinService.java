package com.spring.service;

import com.spring.model.Users;
import com.spring.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

	@Autowired
	private UsersRepository usersRepository;
	
	public UserPasswordHashClass userPasswordHashClass;

	public String joinUser(String userID, String userPassword, String userName) {

		if(userID.equals("") || userPassword.equals("") || userName.equals("")) {
			return "join";
		}

		Users users = new Users();
		users.setUser_id(userID);

		String hashedPassword = userPasswordHashClass.getSHA256(userPassword);
		users.setUser_pw(hashedPassword);
		users.setUser_name(userName);

		usersRepository.save(users);
		return "index";
	}
}
