package com.heejin.project01.admin.controller;

import com.heejin.project01.admin.domain.Admin;
import com.heejin.project01.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/register")
    public String register() {
        return "admin/register";
    }

    @PostMapping("/admin/regist")
    public String regist(Admin admin) {

        adminService.regist(admin);
        return "redirect:/";

    }


}
