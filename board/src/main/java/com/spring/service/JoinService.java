package com.spring.service;

import com.spring.model.User;
import com.spring.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;

public class JoinService {
    public void joinUser(HttpServletRequest request, UserRepository userRepository) {
        String userID = request.getParameter("userID");
        String userPassword = request.getParameter("userPassword");
        String userName = request.getParameter("userName");

        User user = new User();
        user.setUserID(userID);
        user.setUserName(userPassword);
        user.setUserName(userName);

        userRepository.save(user); //save = DB에 저장하는 함수
    }
}
