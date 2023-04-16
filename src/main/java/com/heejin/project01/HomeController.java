package com.heejin.project01;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Log4j2
@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session) {
        log.info("홈컨트롤러 -> 현재 세션 정보 : "+session.getAttribute("user"));
        return "index";
    }


}
