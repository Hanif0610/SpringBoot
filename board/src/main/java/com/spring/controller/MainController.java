package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value="/")
    public String index() {
        return "index";
    }

    //joinPage에서 요청이 오면 join.html로 넘어감
    @RequestMapping(value="joinPage")
    public String joinPage() {
        return "join";
    }
}
