package com.heejin.project01.admin.service;

import com.heejin.project01.admin.domain.Admin;
import com.heejin.project01.admin.repository.AdminMapper;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminService{

    @Autowired
    private final AdminMapper adminMapper;

    // 회원가입 처리

    public boolean regist(Admin admin){
        return adminMapper.regist(admin);
    }

}
