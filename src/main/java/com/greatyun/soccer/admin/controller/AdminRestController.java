package com.greatyun.soccer.admin.controller;


import com.greatyun.soccer.admin.domain.Admin;
import com.greatyun.soccer.admin.dto.AdminDTO;
import com.greatyun.soccer.admin.service.AdminService;
import com.greatyun.soccer.common.dto.ResultAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@Slf4j
@RequestMapping(produces = MediaTypes.HAL_JSON_VALUE)
public class AdminRestController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/api/v1/admin/login")
    public ResponseEntity adminLogin(@RequestBody @Valid AdminDTO adminDTO , Errors errors) {
        if(errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResultAPI.error("잘못된 요청입니다."));
        }
        Optional<Admin> optionalAdmin = adminService.findAdminByAdminId(adminDTO.getAdminId());
        if(!optionalAdmin.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResultAPI.error("존재하지 않는 회원입니다."));
        }
        return ResponseEntity.status(HttpStatus.OK).body(ResultAPI.success("완료되었습니다."));
    }

}
