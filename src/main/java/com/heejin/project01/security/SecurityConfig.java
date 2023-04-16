package com.heejin.project01.security;

import com.heejin.project01.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    AdminService adminService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }


    // hasRole('role1') -> 권한(role1)을 가지고 있는 경우
    // hasAnyRole('role1', 'role2') -> 권한들(role1, role2) 하나라도 가지고 있을 경우 (갯수제한 x)
    // permitAll -> 권한 있든말든 모두 접근 가능
    // denyAll -> 궈난 있든 말든 모두 접근 불가능
    // isAnonymous() -> Anonymous 사용자일 경우 (인증하지 않은 사용자)
    // isRememberMe() -> Remember-me 기능으로 로그인한 사용자일 경우
    // isAuthenticated() -> Anonymous 사용자가 아닐경우 (인증을 한 사용자)
    // isFullyAuthenticated() -> Anounymous 사용자가 아니고 Remmber-me 기능으로 로그인 하지 않은 사용자일 경우


    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()// 각 경오레 따른 권한 지정
                .antMatchers("/","/login","/register","/board","/assets/**").permitAll()
                .antMatchers(HttpMethod.POST,"/admin/regist","/admin/login").permitAll() // post접근일경우
                .antMatchers().hasAnyRole()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") // 로그인이 수행될 경로
                .loginProcessingUrl("/admin/login") // 로그인form의 action과 일치시켜야함
                .usernameParameter("user_email")
                .passwordParameter("user_pass")
                    .defaultSuccessUrl("/login_success",true) // 로그인 성공시 이동할 경로
                    .permitAll()
                    .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling()
                //.accessDeniedPage("/accessDenied_page") // 권한이 없는 대상이 접속을 시도했을때
                .and()
                .csrf()// 이거랑 밑에꺼는 post방식일때 필요
                .ignoringAntMatchers("/admin/login")
                .ignoringAntMatchers("/admin/regist")

                ;

        return httpSecurity.build();
    }

}
