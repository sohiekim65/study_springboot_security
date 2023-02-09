package com.study.study_springboot_security.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping({"/"})      // 일반 사용자와 관리자가 접속 가능
    public ModelAndView main(ModelAndView modelAndView) {
    // spring이 갖고있는 모든 세팅 정보 가져오고 그중 Authentication가져옴
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            
        String username = null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();   // 로그인 상태에서 확인 가능
        } else {
            username = principal.toString();    // 로그아웃 상태에서 확인 가능
        }

        String viewName = "/WEB-INF/views/main.jsp";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    @GetMapping({"/admin"})     // 관리자 접속하는 곳
    public ModelAndView admin(ModelAndView modelAndView) {
        String viewName = "/WEB-INF/views/admin.jsp";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

}
