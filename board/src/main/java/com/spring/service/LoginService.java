package com.spring.service;

import com.spring.model.Users;
import com.spring.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    @Autowired
    private UserPasswordHashClass userPasswordHashClass;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    HttpSession session;

    //아이디 또는 비번을 입력하지 않고 submit하면 로그인이 되지 않고 다시 login창으로 가게 함
    public String login(String userID, String userPassword) {
        if(userID.equals("") || userPassword.equals("")) {
            return "login";
        }
        String hashedPassword = userPasswordHashClass.getSHA256(userPassword);

        Users users = usersRepository.findByUserIDAndUserPassword(userID, hashedPassword);
        if(users == null) {
            return "login";
        }
        session.setAttribute("loginUser", users);
        return "index";
    }
}
