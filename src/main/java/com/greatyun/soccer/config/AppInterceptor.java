package com.greatyun.soccer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class AppInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        String requestURI = request.getRequestURI();
//        if(requestURI.startsWith("/member")) {
//            List<ViewData> list = viewDataRepository.findAll();
//            if(list.size() > 0) {
//
//
//            }
//        }

        return true;

    }
}
