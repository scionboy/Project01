package com.heejin.project01.admin.service;

import com.heejin.project01.admin.domain.Admin;
import com.heejin.project01.admin.repository.AdminMapper;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminService implements UserDetailsService {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private final AdminMapper adminMapper;

    // 회원가입 처리
    public boolean regist(Admin admin) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        admin.setUser_pass(passwordEncoder.encode(admin.getUser_pass()));

        return adminMapper.regist(admin);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminMapper.selectOne(username);
        log.info("로그인정보 : " + admin);
        admin.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(admin.getRole())));
        return admin;
    }

    public Admin setLoginSession(HttpSession session){
        Admin user = null;
        session.removeAttribute("user");
        Object securityContextObject = session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
        if(securityContextObject !=null){
            SecurityContext securityContext = (SecurityContext) securityContextObject;
            Authentication authentication = securityContext.getAuthentication();
            user = (Admin) authentication.getPrincipal();
            log.info("셋로그인세션메서드, 현재 로그인하는 정보 : " + user);
            session.setAttribute("user",user);
        }

        return user;
    }

}
