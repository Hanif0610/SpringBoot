package com.spring.service;

import com.spring.model.Users;
import com.spring.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserPasswordHashClass userPasswordHashClass;

    @Autowired
    private UsersRepository usersRepository;

    public String login(String userID, String userPassword) {
        if(userID.equals("") || userPassword.equals("")) {
            return "login";
        }
        String hashedPassword = userPasswordHashClass.getSHA256(userPassword);

        Users users = usersRepository.findByUser_idAndUser_pw(userID, userPassword);
        if(users == null) {
            return "login";
        }
        return "index";
    }
}
