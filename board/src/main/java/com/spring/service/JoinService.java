package com.spring.service;

import javax.servlet.http.HttpServletRequest;

import com.spring.model.Users;
import com.spring.repository.UsersRepository;

public class JoinService {
	
	public void joinUser(HttpServletRequest request, UsersRepository usersRepository) {
		String userID = request.getParameter("user_id");
		String userPassword = request.getParameter("user_pw");
		String userName = request.getParameter("user_name"); 
		
		Users users = new Users();
		users.setUser_id(userID);
		users.setUser_pw(userPassword);
		users.setUser_name(userName);
		
		usersRepository.save(users);
	}
}
