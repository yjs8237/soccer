package com.greatyun.soccer.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class MemberController {

    @GetMapping("/member/main")
    public ModelAndView main(Map<String , String > model) {
        return new ModelAndView("member/main" , model);
    }

}
