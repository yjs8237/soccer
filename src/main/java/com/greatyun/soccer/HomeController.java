package com.greatyun.soccer;

import com.greatyun.soccer.member.domain.Member;
import com.greatyun.soccer.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/")
    @ResponseBody
    public String home() {
        List<Member> members = memberService.testCustom("jisang");
        return String.valueOf(members.size());
    }
}
