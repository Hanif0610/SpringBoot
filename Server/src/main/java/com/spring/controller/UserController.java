package com.spring.controller;

import com.spring.dao.UserDAO;
import com.spring.model.UserSignIn;
import com.spring.model.UserSignUp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.execption.*;

import java.sql.SQLException;

@RestController
public class UserController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/joinRequest")
    public UserSignUp join(@RequestBody UserSignUp userSignUp) {
        if(userSignUp == null) throw new SignUpFaildException();
        Boolean join = new UserDAO().join(userSignUp.getUserID(), userSignUp.getUserPassword(), userSignUp.getUserName(), userSignUp.getUserEmail());

        return userSignUp;
    }

    @PostMapping("/loginRequest")
    public UserSignIn login(@RequestBody UserSignIn userSignIn) throws SQLException {
        if(userSignIn == null) throw new InvalidBodyException();
        UserSignIn Log = new UserDAO().login(userSignIn.getUserID(), userSignIn.getUserPassword());


        return userSignIn;
    }
}
