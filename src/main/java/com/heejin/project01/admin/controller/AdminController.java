package com.heejin.project01.admin.controller;

import com.heejin.project01.admin.domain.Admin;
import com.heejin.project01.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    @Autowired
    private final AdminService adminService;


    // 회원가입 페이지
    @GetMapping("/register")
    public String register() {
        return "admin/register";
    }

    // 회원가입 처리
    @PostMapping("/admin/regist")
    public String regist(Admin admin) {
        adminService.regist(admin);
        return "redirect:/";
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String login(HttpSession session){
        return "admin/login";
    }

    @GetMapping("/login_success")
    public String loginSuccess(HttpSession session){
        log.info("나 실행됐냐?");
        adminService.setLoginSession(session);
        return "index";
    }


}
