package com.spring.controller;

import com.spring.model.Freeboard;
import com.spring.service.freeboard.FreeboardListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FreeboardController {

    @Autowired
    private HttpSession session;

    @Autowired
    private FreeboardListService freeboardListService;

    @GetMapping("/freeboard")
    public String freeboard(@RequestParam(value = "pageNum", defaultValue = "1")String pageNum) { //RequestParm : 단일 파라미터를 전달 받을 때 사용
        List<Freeboard> freeboardList = freeboardListService.freeboardList(pageNum);
        if(freeboardList == null) {
            return "freeboard";
        }
        session.setAttribute("boardList", freeboardList);
        return "freeboard";
    }
}
