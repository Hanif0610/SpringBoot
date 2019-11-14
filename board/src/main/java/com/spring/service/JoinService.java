package com.spring.service;

import com.spring.model.Users;
import com.spring.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private UserPasswordHashClass userPasswordHashClass;

	public String joinUser(String userID, String userPassword, String userName) {

		//아이디 또는 비번을 입력하지 않고 submit하면 로그인이 되지 않고 다시 join창으로 가게 함
		if(userID.equals("") || userPassword.equals("") || userName.equals("")) {
			return "join";
		}

		Users users = new Users();
		users.setUserID(userID);

		String hashedPassword = userPasswordHashClass.getSHA256(userPassword);
		users.setUserPassword(hashedPassword);
		users.setUserName(userName);

		usersRepository.save(users);
		return "index";
	}
}
