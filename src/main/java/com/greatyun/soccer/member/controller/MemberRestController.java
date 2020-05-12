package com.greatyun.soccer.member.controller;

import com.greatyun.soccer.common.dto.ResultAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1" , produces = MediaTypes.HAL_JSON_VALUE)
public class MemberRestController {

    @GetMapping("/member")
    public ResponseEntity home() {
        log.info("controller!!");
        return ResponseEntity.ok("success");
    }
}
